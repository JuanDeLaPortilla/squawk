package com.squawk.webapp.controllers;

import com.squawk.webapp.models.User;
import com.squawk.webapp.services.LoginService;
import com.squawk.webapp.services.LoginServiceImpl;
import com.squawk.webapp.services.UserService;
import com.squawk.webapp.services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet(name = "sessionServlet", value = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "logout":
                    this.logout(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "login":
                    this.login(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index").forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService service = new UserServiceImpl((Connection) req.getAttribute("conn"));
        Optional<User> optionalUser = service.login(email, password);

        if (optionalUser.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser);

            resp.sendRedirect(req.getContextPath() + "/index");
        } else {
            resp.sendRedirect(req.getContextPath() + "/index");
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<User> user = auth.getUser(req);
        if(user.isPresent()){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+"/index");
    }
}
