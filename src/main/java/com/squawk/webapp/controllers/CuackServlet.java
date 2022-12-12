package com.squawk.webapp.controllers;

import com.google.gson.Gson;
import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.Tag;
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

@WebServlet(name = "CuackServlet", value = "/cuack")
public class CuackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        TagService tagService = new TagServiceImpl(conn);
        LikeCuackService likeService = new LikeCuackServiceImpl(conn);
        DislikeCuackService dislikeService = new DislikeCuackServiceImpl(conn);
        LoginService loginService = new LoginServiceImpl();

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "viewCuack":
                    this.viewCuack(request, response, service, loginService, likeService, dislikeService);
                    break;
                case "viewByTag":
                    this.viewByTag(request, response, tagService);
                    break;
                case "send":
                    String cuacksToSend = this.sendCuacks(request, service);
                    out.print(cuacksToSend);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void viewCuack(HttpServletRequest req, HttpServletResponse resp, CuackService service, LoginService loginService, LikeCuackService likeService, DislikeCuackService dislikeService) throws ServletException, IOException {
        Optional<User> sessionUser = loginService.getUser(req);
        try {
            if (sessionUser.isPresent()) {//Si el usuario inicio sesion
                Long sessionId = sessionUser.get().getId();//Se obtiene la id del usuario

                long cuackId = getCuackId(req);//Se obtiene la id del cuack

                int liked, disliked;

                if (likeService.isLikedByUser(cuackId, sessionId)) {
                    liked = 1;
                } else {
                    liked = 0;
                }

                if (dislikeService.isDislikedByUser(cuackId, sessionId)) {
                    disliked = 1;
                } else {
                    disliked = 0;
                }
                req.setAttribute("liked", liked);
                req.setAttribute("disliked", disliked);

                sendCuacktoJsp(req, resp, service, likeService, dislikeService, cuackId);
            }
        } catch (NullPointerException e) {//Si no inicio sesion
            long cuackId = getCuackId(req);//Se obtiene la id del cuack
            sendCuacktoJsp(req, resp, service, likeService, dislikeService, cuackId);
        }
    }

    private void sendCuacktoJsp(HttpServletRequest req, HttpServletResponse resp, CuackService service, LikeCuackService likeService, DislikeCuackService dislikeService, long cuackId) throws ServletException, IOException {
        Optional<Cuack> cuackOptional = service.findById(cuackId);//Se busca el cuack
        Cuack cuack = cuackOptional.get();
        req.setAttribute("cuack", cuack);

        int likes = likeService.countLikesOnCuacks(cuackId);
        int dislikes = dislikeService.countDislikesOnCuacks(cuackId);
        req.setAttribute("likes", likes);
        req.setAttribute("dislikes", dislikes);

        double approval = getApproval(likes,dislikes);
        req.setAttribute("approval",String.format("%.2f",approval));

        getServletContext().getRequestDispatcher("/WEB-INF/pages/user/cuack/cuack.jsp").forward(req, resp);
    }

    private void viewByTag(HttpServletRequest req, HttpServletResponse resp, TagService tagService) throws ServletException, IOException {
        long tagId = Long.parseLong(req.getParameter("id"));
        Optional<Tag> tagOptional = tagService.findById(tagId);
        Tag tag = tagOptional.get();
        req.setAttribute("tag", tag);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/user/cuack/cuacksByTag.jsp").forward(req, resp);
    }

    private String sendCuacks(HttpServletRequest request, CuackService service) {
        int start = Integer.parseInt(request.getParameter("start"));//se obtiene el atributo para iniciar el bucle
        Long tagId = Long.parseLong(request.getParameter("id"));

        List<Cuack> cuacksToSend = new ArrayList<Cuack>();//se crea la lista de cuacks a enviar

        List<Cuack> cuacksFounded = service.findByTagId(tagId);//se busca los cuacks
        for (int i = start; i < start + 5; i++) {//se inicia el bucle desde donde se requiere
            if (i < cuacksFounded.size()) {
                cuacksToSend.add(cuacksFounded.get(i));//se añaden los cuacks a otra lista
            }
        }

        Gson gson = new Gson();//se crea un objeto gson
        return gson.toJson(cuacksToSend);//se convierte la lista json
    }

    private double getApproval(int likes, int dislikes){
        return likes*100.0/(dislikes+likes);
    }


    private static long getCuackId(HttpServletRequest req) {
        String idStr;
        try {
            idStr = req.getParameter("id");
        } catch (NullPointerException e) {
            idStr = "";
        }
        long id;
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            id = 0L;
        }
        return id;
    }
}
