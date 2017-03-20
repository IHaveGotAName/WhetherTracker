package com.podd.WeatherTracker.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.podd.WeatherTracker.dto.CityDTO;
import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.UserRole;
import com.podd.WeatherTracker.services.impl.CityService;
import com.podd.WeatherTracker.services.impl.UserService;
import com.podd.WeatherTracker.utilities.Hex;
import com.podd.WeatherTracker.utilities.Parser;
import com.podd.WeatherTracker.utilities.WeatherRequest;
import com.podd.WeatherTracker.utilities.WeatherResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




/**
 * Created by ivegotaname on 09.12.16.
 */
@WebServlet("/AuthorisationServlet")
public class AuthorisationServlet extends HttpServlet {
    private static final Gson gson = new GsonBuilder().create();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        password = Hex.hexSHA512(password);
//        User user = new UserDAO().findByLoginPassword(login, password);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(login);
        userDTO.setPassword(password);
        UserService userService = new UserService();
        userDTO = userService.findUserByLoginAndPassword(userDTO);
           try {
               if (userDTO != null && userDTO.getRole() == UserRole.ADMIN) {
                   HttpSession httpSession = req.getSession();
                   httpSession.setAttribute("user", userDTO);
                   httpSession.setAttribute("userRole", userDTO.getRole());
                   resp.sendRedirect("/AdminServlet");

               } else if (userDTO != null) {
                   CityService cityService = new CityService();
                   CityDTO cityDTO = new CityDTO();
                   Parser parser = new Parser();
                   cityDTO.setCity(userDTO.getCity());
                   cityDTO = cityService.findIdByCity(cityDTO);
                   String city = cityDTO.getId().toString() ;
                   String weatherJson = WeatherRequest.getRawWeather(city);
                   WeatherResponse now = gson.fromJson(weatherJson, WeatherResponse.class);
                   HttpSession httpSession = req.getSession();
                   httpSession.setAttribute("city", cityDTO);
                   httpSession.setAttribute("user", userDTO);
                   httpSession.setAttribute("weather", parser.getWeatherParser(now));
                   resp.sendRedirect("/html/mainIN.jsp");
               } else {
                   resp.sendRedirect("/html/home.jsp");
               }
           } catch (NullPointerException e) {
               e.printStackTrace();
           }
        }




    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/home.jsp");
        rd.forward(req, resp);
    }
}
