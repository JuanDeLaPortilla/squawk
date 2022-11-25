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

@WebServlet(name = "CuackServlet", value = "/cuack")
public class CuackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        LoginService loginService = new LoginServiceImpl();
        this.defaultAction(request,response,service,loginService);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService service,LoginService loginService) throws ServletException, IOException {
        Optional<User> sessionUser = loginService.getUser(req);
        try{
            if (sessionUser.isPresent()) {//Si el usuario inicio sesion
                Long sessionId = sessionUser.get().getId();//Se obtiene la id del usuario

                long cuackId = getCuackId(req);//Se obtiene la id del cuack

                Optional<Cuack> cuackOptional= service.findByIdLiked(cuackId,sessionId);//Se busca el cuack
                redirectToJsp(req, resp, cuackOptional);//Se envia al jsp
            }
        }catch (NullPointerException e){//Si no inicio sesion
            long cuackId = getCuackId(req);//Se obtiene la id del cuack
            Optional<Cuack> cuackOptional= service.findById(cuackId);//Se busca el cuack
            redirectToJsp(req, resp, cuackOptional);//Se envia al jsp
        }
    }

    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp, Optional<Cuack> cuackOptional) throws ServletException, IOException {
        Cuack cuack = cuackOptional.get();
        req.setAttribute("cuack", cuack);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/user/cuack/cuack.jsp").forward(req, resp);
    }

    private static long getCuackId(HttpServletRequest req) {
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
        return id;
    }
}
