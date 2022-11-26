package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.CuackService;
import com.squawk.webapp.services.CuackServiceImpl;
import com.squawk.webapp.services.LoginService;
import com.squawk.webapp.services.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Index", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        LoginService loginService = new LoginServiceImpl();

        Optional<User> user = loginService.getUser(request);

        try {
            if (user.isPresent()) {
                Long id = user.get().getId();
                this.loginAction(request, response, service, id);
            }
        } catch (NullPointerException e) {
            this.defaultAction(request, response, service);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        List<Cuack> cuacks = service.findAll();
        redirectToJsp(req, resp, service, cuacks);
    }

    private void loginAction(HttpServletRequest req, HttpServletResponse resp, CuackService service, Long id) throws ServletException, IOException {
        List<Cuack> cuacks = service.findAllLiked(id);
        redirectToJsp(req, resp, service, cuacks);
    }

    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp, CuackService service, List<Cuack> cuacks) throws ServletException, IOException {
        req.setAttribute("cuacks", cuacks);

        List<Cuack> stories = service.findTopMonthly();
        req.setAttribute("stories", stories);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
