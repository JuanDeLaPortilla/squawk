package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.CuackService;
import com.squawk.webapp.services.CuackServiceImpl;
import com.squawk.webapp.services.UserService;
import com.squawk.webapp.services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService cuackService = new CuackServiceImpl(conn);
        UserService userService = new UserServiceImpl(conn);

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                default:
                    this.defaultAction(request, response, cuackService, userService);
                    break;
            }
        } else {
            this.defaultAction(request, response, cuackService, userService);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService cuackService, UserService userService) throws ServletException, IOException {
        String userIdStr;
        try {
            userIdStr = req.getParameter("id");
        } catch (NullPointerException e) {
            userIdStr = "";
        }
        long userId = getId(userIdStr);

        List<Cuack> cuacks = cuackService.findByUserId(userId);
        req.setAttribute("cuacks", cuacks);

        User user = new User();
        Optional<User> o = userService.findById(userId);
        user = o.get();
        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    private static long getId(String idString) {
        long id;
        try {
            id = Long.parseLong(idString);
        } catch (NumberFormatException | NullPointerException e) {
            id = 0L;
        }
        return id;
    }
}
