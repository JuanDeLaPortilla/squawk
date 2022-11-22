package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.services.CuackService;
import com.squawk.webapp.services.CuackServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CuackServlet", value = "/cuack")
public class CuackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        this.defaultAction(request,response,service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        String idStr;
        try{
            idStr = req.getParameter("id");
        }catch (NullPointerException e){
            idStr = "";
        }
        long id;
        try{
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            id = 0L;
        }

        Cuack cuack;
        Optional<Cuack> cuackOptional= service.findById(id);
        cuack = cuackOptional.get();

        req.setAttribute("cuack", cuack);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/user/cuack/cuack.jsp").forward(req, resp);
    }
}
