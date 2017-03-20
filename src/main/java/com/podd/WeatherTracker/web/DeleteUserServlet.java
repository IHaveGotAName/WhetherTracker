package com.podd.WeatherTracker.web;



import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.services.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivegotaname on 15.12.16.
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer userId = Integer.valueOf(req.getParameter("idUserDelete"));
            UserService userService = new UserService();
            UserDTO userDTO = userService.findById(userId);
            userService.delete(userDTO);

        } finally {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminServlet");
            rd.forward(req, resp);
        }


    }
}
