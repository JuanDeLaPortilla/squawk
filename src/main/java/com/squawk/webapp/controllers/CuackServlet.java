package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Cuack;
import com.squawk.webapp.models.Tag;
import com.squawk.webapp.services.CuackService;
import com.squawk.webapp.services.CuackServiceImpl;
import com.squawk.webapp.services.TagService;
import com.squawk.webapp.services.TagServiceImpl;
import com.squawk.webapp.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "cuacks", urlPatterns = "/cuacks")
@MultipartConfig(
        location = "G:\\Juan Utp\\Ciclo VI\\Integrador_I\\Avance_Squawk_Maven\\src\\main\\webapp\\cuack_pictures",
        fileSizeThreshold = 1024 * 1024,  //  1 MB
        maxFileSize = 1024 * 1024 * 10,   // 10 MB
        maxRequestSize = 1024 * 1024 * 11 // 11 MB
)
public class CuackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editCuackGet(req, resp, service);
                    break;
                case "delete":
                    this.deleteCuack(req, resp, service);
                    break;
                default:
                    this.defaultAction(req, resp, service);
                    break;
            }
        } else {
            this.defaultAction(req, resp, service);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CuackService service = new CuackServiceImpl(conn);
        TagService tagService = new TagServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                case "edit":
                    this.addCuack(req, resp, service, tagService);
                    this.defaultAction(req,resp,service);
                    break;
                case "editPicture":
                    this.editPicture(req,resp,service);
                    this.defaultAction(req,resp,service);
                    break;
                default:
                    this.defaultAction(req, resp, service);
                    break;
            }
        } else {
            this.defaultAction(req, resp, service);
        }
    }

    //Private Methods
    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        List<Cuack> cuacks = service.findAll();

        req.setAttribute("cuacks", cuacks);
        getServletContext().getRequestDispatcher("/cuacks.jsp").forward(req, resp);
    }

    private void addCuack(HttpServletRequest req, HttpServletResponse resp, CuackService service, TagService tagService) throws ServletException, IOException {
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
        double price;
        try{
            price = Double.parseDouble(req.getParameter("price"));
        } catch (NumberFormatException e){
            price = 0D;
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
        Cuack cuack = getCuackInfo(description,imgPath,url,title,price,isEdited,cuackId,tagId,tagService);

        //llama al service para pasarle el cuack
        service.add(cuack);
    }


    private void deleteCuack(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        //obtener id
        long id = getCuackId(req);
        //se pasa la id al service
        service.delete(id);
        //devuelve el listado de usuarios
        this.defaultAction(req, resp, service);
    }

    private void editPicture(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        //obtener id
        long id = getCuackId(req);
        //recuperamos la imagen
        try {
            String imgPath = getImgPath(req);

            //Se sube el directorio a la base de datos
            service.uploadPicture(id,imgPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void editCuackGet(HttpServletRequest req, HttpServletResponse resp, CuackService service) throws ServletException, IOException {
        //obtener id
        long id = getCuackId(req);
        //se llama al servicio para buscar al usuario por id y se guarda
        Cuack cuack;
        Optional<Cuack> o = service.findById(id);
        cuack = o.get();

        //mandamos el usuario al jsp
        req.setAttribute("cuack", cuack);

        //redireccionamos al formulario para editar
        String jspEdit = "/WEB-INF/pages/dashboard/cuacks/editCuack.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, resp);
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

    private static Cuack getCuackInfo(String description,String img, String url, String title, double price,int isEdited, long id, long tagId, TagService tagService) {
        Cuack cuack = new Cuack();
        Tag tag;
        Optional<Tag> optionalTag = tagService.findById(tagId);
        tag = optionalTag.get();

        cuack.setCuackID(id);
        cuack.setTag(tag);
        cuack.setDesc(description);
        cuack.setImg(img);
        cuack.setUrl(url);
        cuack.setRating(0D);
        cuack.setStatus(1);
        cuack.setTitle(title);
        cuack.setPrice(price);
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
