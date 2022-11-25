package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.*;
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
        LoginService loginService = new LoginServiceImpl();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                default:
                    this.defaultAction(request, response, cuackService, userService, loginService);
                    break;
            }
        } else {
            this.defaultAction(request,response,cuackService,userService, loginService);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService cuackService, UserService userService, LoginService loginService) throws ServletException, IOException {
        Optional<User> sessionUser = loginService.getUser(req);
        try{
            if (sessionUser.isPresent()) {
                Long sessionId = sessionUser.get().getId();

                long userId = getUserId(req);

                List<Cuack> cuacks = cuackService.findByUserIdLiked(userId,sessionId);
                redirectToJsp(req, resp, userService, userId, cuacks);
            }
        }catch (NullPointerException e){
            long userId = getUserId(req);

            List<Cuack> cuacks = cuackService.findByUserId(userId);
            redirectToJsp(req, resp, userService, userId, cuacks);
        }
    }

    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp, UserService userService, long userId, List<Cuack> cuacks) throws ServletException, IOException {
        req.setAttribute("cuacks", cuacks);

        User user = new User();
        Optional<User> o = userService.findById(userId);
        user = o.get();
        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    private static long getUserId(HttpServletRequest req) {
        String userIdStr;
        try {
            userIdStr = req.getParameter("id");
        } catch (NullPointerException e) {
            userIdStr = "";
        }
        long userId;
        try {
            userId = Long.parseLong(userIdStr);
        } catch (NumberFormatException | NullPointerException e) {
            userId = 0L;
        }
        return userId;
    }
}
