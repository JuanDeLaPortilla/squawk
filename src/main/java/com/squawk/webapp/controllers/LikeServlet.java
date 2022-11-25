package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.LikeCuack;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        LikeCuackService likeCuackService = new LikeCuackServiceImpl(conn);
        CuackService cuackService = new CuackServiceImpl(conn);
        UserService userService = new UserServiceImpl(conn);

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");


        switch (action) {
            case "likeCuack":
                String msg = likeCuack(request, userService, cuackService, likeCuackService);
                out.print(msg);
                break;
            case "likeComment":
                this.likeComment();
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String likeCuack(HttpServletRequest request, UserService userService, CuackService cuackService, LikeCuackService service) {
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long cuackId = Long.parseLong(request.getParameter("cuackId"));
        String msg;

        if (service.isLikedByUser(cuackId, userId)) {
            msg = service.delete(cuackId, userId);
        } else {
            msg = service.add(cuackId, userId);
        }
        return msg;
    }

    private void likeComment() {

    }
}
