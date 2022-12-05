package com.squawk.webapp.controllers;

import com.squawk.webapp.services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        LikeCuackService likeCuackService = new LikeCuackServiceImpl(conn);
        DislikeCuackService dislikeCuackService = new DislikeCuackServiceImpl(conn);

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");


        switch (action) {
            case "likeCuack":
                String likeMsg = likeCuack(request, likeCuackService, dislikeCuackService);
                out.print(likeMsg);
                break;
            case "dislikeCuack":
                String dislikeMsg = dislikeCuack(request, likeCuackService, dislikeCuackService);
                out.print(dislikeMsg);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String likeCuack(HttpServletRequest request, LikeCuackService likeCuackService, DislikeCuackService dislikeCuackService) {
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long cuackId = Long.parseLong(request.getParameter("cuackId"));
        String msg;

        if (dislikeCuackService.isDislikedByUser(cuackId, userId)) {//si al usuario le disgustaba el cuack
            msg = dislikeCuackService.delete(cuackId, userId);//se elimina el no me gusta
            msg+= likeCuackService.add(cuackId, userId);//se añade un me gusta
        } else if (likeCuackService.isLikedByUser(cuackId, userId)) {//si ya le gustaba
            msg = likeCuackService.delete(cuackId, userId);//se elimina el me gusta
        } else {//sino le habia gustado
            msg = likeCuackService.add(cuackId, userId);//se añade el like
        }
        return msg;
    }

    private String dislikeCuack(HttpServletRequest request, LikeCuackService likeCuackService, DislikeCuackService dislikeCuackService) {
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long cuackId = Long.parseLong(request.getParameter("cuackId"));
        String msg;

        if (likeCuackService.isLikedByUser(cuackId, userId)) {//si al usuario le gustaba el cuack
            msg = likeCuackService.delete(cuackId, userId);//se elimina el me gusta
            msg+= dislikeCuackService.add(cuackId, userId);//se añade un no me gusta
        } else if (dislikeCuackService.isDislikedByUser(cuackId, userId)) {//si ya no le gustaba
            msg = dislikeCuackService.delete(cuackId, userId);//se elimina el no me gusta
        } else {//sino le habia no gustado
            msg = dislikeCuackService.add(cuackId, userId);//se añade el dislike
        }
        return msg;
    }
}