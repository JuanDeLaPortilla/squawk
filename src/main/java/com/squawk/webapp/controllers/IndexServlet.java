package com.squawk.webapp.controllers;

import com.google.gson.Gson;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.services.CuackService;
import com.squawk.webapp.services.CuackServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Index", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if(action != null){
            switch (action){
                case "send":
                    String cuacks = this.sendCuacks(request,response,service);
                    out.print(cuacks);
                    break;
                default:
                    this.defaultAction(request,response,service);
                    break;
            }
        }else{
            this.defaultAction(request,response,service);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        List<Cuack> stories = service.findTopMonthly();
        req.setAttribute("stories", stories);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private String sendCuacks(HttpServletRequest request, HttpServletResponse response, CuackService service){
        int start = Integer.parseInt(request.getParameter("start"));//se obtiene el atributo para iniciar el bucle
        int logged = Integer.parseInt(request.getParameter("logged"));//se obtiene si el usuario ha iniciado sesion

        List<Cuack> cuacksToSend = new ArrayList<Cuack>();//se crea la lista de cuacks a enviar

        if (logged == 0) {//si no ha iniciado sesion
            List<Cuack> cuacksFounded = service.findAll();//se busca los cuacks sin contar el like
            for (int i = start; i < start + 5; i++) {//se inicia el bucle desde donde se requiere
                if (i < cuacksFounded.size()){
                    cuacksToSend.add(cuacksFounded.get(i));//se añaden los cuacks a otra lista
                }
            }
        }else{
            if(logged == 1){
                Long id = Long.parseLong(request.getParameter("id"));//se obtiene el id del usuario
                List<Cuack> cuacksFounded = service.findAllLiked(id);//se buscan los cuacks y si el usuario le ha dado like
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
}
