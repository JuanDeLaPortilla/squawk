package com.squawk.webapp.controllers;

import com.google.gson.Gson;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.models.countByMonth;
import com.squawk.webapp.services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        countByMonthService service = new countByMonthServiceImpl(conn);
        UserService userService = new UserServiceImpl(conn);
        CuackService cuackService = new CuackServiceImpl(conn);
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "sendCuacks":
                    String cantCuack = this.cantCuack(request, cuackService);
                    out.print(cantCuack);
                    break;
                case "sendUsers":
                    String cantUser = this.cantUser(request, userService);
                    out.print(cantUser);
                    break;
                default:
                    this.defaultAction(request, response, cuackService,userService);
                    break;
            }
        } else {
            this.defaultAction(request, response, cuackService,userService);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService cuackService, UserService userService) throws ServletException, IOException {
        Integer registeredUsers = userService.countMonthlyUsers();
        req.setAttribute("usuariosRegistrados",registeredUsers);

        Integer cuacks = cuackService.countMonthlyCuacks();
        req.setAttribute("cuacks",cuacks);

        Integer activeUsers = userService.countActiveUsers();
        req.setAttribute("usuariosActivos",activeUsers);

        Integer users = userService.countAllUsers();

        double porcentage = (activeUsers*100.00)/users;
        req.setAttribute("porcentage",porcentage);

        List<User> staff = userService.findStaffLazy();
        req.setAttribute("staff",staff);

        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
    
    private String cantCuack(HttpServletRequest request, CuackService cuackService) {
        List<Object> cantCuack = cuackService.findByMonth();

        Gson gson = new Gson();//se crea un objeto gson
        return gson.toJson(cantCuack);//se convierte la lista json
    }
    
    private String cantUser(HttpServletRequest request, UserService userService) {
        List<Object> cantUser = userService.findByMonth();

        Gson gson = new Gson();//se crea un objeto gson
        return gson.toJson(cantUser);//se convierte la lista json
    }
}
