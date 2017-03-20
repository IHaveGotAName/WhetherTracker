package com.podd.WeatherTracker.web;


import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.UserRole;
import com.podd.WeatherTracker.services.impl.UserService;
import com.podd.WeatherTracker.utilities.Hex;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.podd.WeatherTracker.utilities.AddSlashes.addSlashes;


/**
 * Created by ivegotaname on 09.12.16.
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = addSlashes(req.getParameter("firstname"));
        String surname = addSlashes(req.getParameter("secondname"));
        String login = addSlashes(req.getParameter("login"));
        String password = addSlashes(req.getParameter("password"));
        password = addSlashes(Hex.hexSHA512(password));
        String birthday = addSlashes(req.getParameter("birthday"));
        String email = addSlashes(req.getParameter("email"));
        String city = addSlashes(req.getParameter("city"));


        UserService userService = new UserService();
        if (!userService.checkLoginToEquals(login)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(name);
            userDTO.setSecondName(surname);
            userDTO.setLogin(login);
            userDTO.setPassword(password);
            userDTO.setBirthday(birthday);
            userDTO.setEmail(email);
            userDTO.setRole(UserRole.USER);
            userDTO.setCity(city);
            userService.create(userDTO);

            resp.sendRedirect("/html/home.jsp");

        }else {
            PrintWriter out = resp.getWriter();
            out.println("<font color=\"red\">Login is occupied!</font>");
            RequestDispatcher rs = req.getRequestDispatcher("/html/registration.jsp");
            rs.include(req, resp);
        }
    }
}