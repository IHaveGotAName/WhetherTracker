package com.podd.WeatherTracker.web;



import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.UserRole;
import com.podd.WeatherTracker.services.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivegotaname on 13.12.16.
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();

        try {
            HttpSession httpSession = req.getSession();
            UserDTO userDTO = (UserDTO) httpSession.getAttribute("user");
            if (userDTO.getRole() != UserRole.ADMIN) {
                resp.sendRedirect("/");
            }
        } catch (IOException e) {
            resp.sendRedirect("/");
        }

        List<UserDTO> userDTOs = userService.findAll();
        req.getSession().setAttribute("userDTOs", userDTOs);



        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/adminMain.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserService();
        List<UserDTO> userDTOs = userService.findAll();
        req.getSession().setAttribute("userDTOs", userDTOs);



        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/adminMain.jsp");
        rd.forward(req, resp);
    }
}

