package com.squawk.webapp.controllers;

import com.squawk.webapp.models.countByMonth;
import com.squawk.webapp.services.countByMonthService;
import com.squawk.webapp.services.countByMonthServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        countByMonthService service = new countByMonthServiceImpl(conn);
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                default:
                    this.defaultAction(request,response,service);
                    break;
            }
        } else {
            this.defaultAction(request,response,service);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, countByMonthService service) throws ServletException, IOException {
        List<countByMonth> cantCuack = service.findCantCuacks();
        req.setAttribute("cantCuack", cantCuack);
        List<countByMonth> cantUser = service.findCantUsers();
        req.setAttribute("cantUser", cantUser);
        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
