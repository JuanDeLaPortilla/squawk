package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.Tag;
import com.squawk.webapp.models.User;
import com.squawk.webapp.services.*;
import com.squawk.webapp.util.Util;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "submit", value = "/submit")
@MultipartConfig(
        location = "G:\\Juan Utp\\Ciclo VI\\Integrador_I\\Avance_Squawk_Maven\\src\\main\\webapp\\cuack_pictures",
        fileSizeThreshold = 1024 * 1024,  //  1 MB
        maxFileSize = 1024 * 1024 * 10,   // 10 MB
        maxRequestSize = 1024 * 1024 * 11 // 11 MB
)

public class SubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        TagService tagService = new TagServiceImpl(conn);

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                default:
                    this.defaultAction(request, response, tagService);
                    break;
            }
        } else {
            this.defaultAction(request, response, tagService);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        CuackService cuackService = new CuackServiceImpl(conn);
        TagService tagService = new TagServiceImpl(conn);
        UserService userService = new UserServiceImpl(conn);

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "submit":
                    this.submit(request, response, cuackService, tagService, userService);
                    break;
                default:
                    this.defaultAction(request, response,tagService);
            }
        }else{
            this.defaultAction(request,response,tagService);
        }
    }

    //Private Methods
    private void submit(HttpServletRequest req, HttpServletResponse resp, CuackService cuackService, TagService tagService, UserService userService) throws ServletException, IOException {
        //recuperamos los valores del formulario
        String description = req.getParameter("description");
        String url = req.getParameter("url");
        String title = req.getParameter("title");

        //obtener id
        long cuackId = getCuackId(req);
        //valores con try-catch
        long tagId;
        try {
            tagId = Long.parseLong(req.getParameter("tagId"));
        } catch (NumberFormatException e) {
            tagId = 1;
        }
        long userId;
        try{
            userId = Long.parseLong(req.getParameter("userId"));
        }catch (NumberFormatException e){
            userId = 0;
        }
        int isEdited;
        try{
            isEdited = Integer.parseInt(req.getParameter("isEdited"));
        } catch (NumberFormatException e){
            isEdited = 0;
        }
        String imgPath;
        try{
            imgPath = getImgPath(req);
        }catch (Exception e){
            imgPath = "";
            e.printStackTrace();
        }

        //crea un cuack que recibe cada valor
        Cuack cuack = getCuackInfo(description,imgPath,url,title,isEdited,cuackId,tagId,userId,tagService,userService);

        //llama al service para pasarle el cuack
        cuackService.add(cuack);
    }

    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, TagService tagService) throws ServletException, IOException {
        List<Tag> tags = tagService.findAll();

        req.setAttribute("tags",tags);
        getServletContext().getRequestDispatcher("/submit.jsp").forward(req, resp);
    }

    private static long getCuackId(HttpServletRequest req) {
        String idStr;
        try {
            idStr = req.getParameter("idCuack");
        } catch (NullPointerException e) {
            idStr = "";
        }
        long cuackId;
        try {
            cuackId = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            cuackId = 0L;
        }
        return cuackId;
    }

    private static Cuack getCuackInfo(String description, String img, String url, String title, int isEdited, long cuackId, long tagId, long userId, TagService tagService, UserService userService) {
        Cuack cuack = new Cuack();
        Tag tag;
        Optional<Tag> optionalTag = tagService.findById(tagId);
        tag = optionalTag.get();
        User user;
        Optional<User> optionalUser = userService.findById(userId);
        user = optionalUser.get();

        cuack.setCuackID(cuackId);
        cuack.setUser(user);
        cuack.setTag(tag);
        cuack.setDesc(description);
        cuack.setImg(img);
        cuack.setUrl(url);
        cuack.setRating(0D);
        cuack.setStatus(1);
        cuack.setTitle(title);
        cuack.setEdited(isEdited);
        return cuack;
    }

    private String getImgPath(HttpServletRequest req) throws IOException, ServletException {
        Part img = req.getPart("img");
        img.write(Util.getFileName(img));//se sube la imagen al proyeto
        img.write(getServletContext().getRealPath("\\" + "cuack_pictures"+  File.separator + Util.getFileName(img)));//se sube la imagen al servidor

        //se crea la direccion de la imagen
        String imgPath = getServletContext().getContextPath()+ "\\" + "cuack_pictures"+ File.separator + Util.getFileName(img);
        return imgPath;
    }
}
