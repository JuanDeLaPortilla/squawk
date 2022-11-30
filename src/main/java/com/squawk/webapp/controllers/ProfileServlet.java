package com.squawk.webapp.controllers;

import com.google.gson.Gson;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService cuackService = new CuackServiceImpl(conn);
        UserService userService = new UserServiceImpl(conn);
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "send":
                    String cuacks = this.sendCuacks(request,response,cuackService);
                    out.print(cuacks);
                    break;
                default:
                    this.defaultAction(request,response,userService);
            }
        } else {
            this.defaultAction(request,response,userService);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, UserService userService) throws ServletException, IOException {
        Long userId = getUserId(req);
        Optional<User> o = userService.findById(userId);
        User user = o.get();
        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    private String sendCuacks(HttpServletRequest request, HttpServletResponse response, CuackService service){
        int start = Integer.parseInt(request.getParameter("start"));//se obtiene el atributo para iniciar el bucle
        int logged = Integer.parseInt(request.getParameter("logged"));//se obtiene si el usuario ha iniciado sesion
        long userId = getUserId(request);

        List<Cuack> cuacksToSend = new ArrayList<Cuack>();//se crea la lista de cuacks a enviar

        if (logged == 0) {//si no ha iniciado sesion
            List<Cuack> cuacksFounded = service.findByUserId(userId);//se busca los cuacks sin contar el like
            for (int i = start; i < start + 5; i++) {//se inicia el bucle desde donde se requiere
                if (i < cuacksFounded.size()){
                    cuacksToSend.add(cuacksFounded.get(i));//se añaden los cuacks a otra lista
                }
            }
        }else{
            if(logged == 1){
                Long sessionId = Long.parseLong(request.getParameter("sessionId"));//se obtiene el id del usuario
                List<Cuack> cuacksFounded = service.findByUserIdLiked(userId,sessionId);;//se buscan los cuacks y si el usuario le ha dado like
                for (int i = start; i < start + 5; i++) {//se inicia el bucle desde donde se requiere
                    if (i < cuacksFounded.size()) {
                        cuacksToSend.add(cuacksFounded.get(i));//se añaden los cuacks a otra lista
                    }
                }
            }
        }

        Gson gson = new Gson();//se crea un objeto gson
        return gson.toJson(cuacksToSend);//se convierte la lista json
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
