package com.podd.WeatherTracker.web;



import com.podd.WeatherTracker.dto.CityDTO;
import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.City;
import com.podd.WeatherTracker.services.impl.CityService;
import com.podd.WeatherTracker.services.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ivegotaname on 21.02.17.
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 /*       HttpSession httpSession = req.getSession();
        httpSession.getAttribute("userID");
        Integer userId = Integer.valueOf(req.getParameter("userID"));
        UserService userService = new UserService();
        CityService cityService = new CityService();
        UserDTO userDTO = userService.findById(userId);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity(userDTO.getCity());
        cityDTO = cityService.findIdByCity(cityDTO);
        httpSession.setAttribute("user", userDTO);
        httpSession.setAttribute("cityID", cityDTO.getId());
        resp.sendRedirect("/http/mainIN.jsp");*/

    }


}