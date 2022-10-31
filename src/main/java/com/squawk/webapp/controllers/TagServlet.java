package com.squawk.webapp.controllers;

import com.squawk.webapp.models.Tag;
import com.squawk.webapp.services.TagService;
import com.squawk.webapp.services.TagServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "tags", value = "/tags")
public class TagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        TagService service = new TagServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editTagGet(req, resp, service);
                    break;
                case "delete":
                    this.deleteTag(req, resp, service);
                    break;
                default:
                    this.defaultAction(req, resp, service);
                    break;
            }
        } else {
            this.defaultAction(req, resp, service);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        TagService service = new TagServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                case "edit":
                    this.addTag(req, resp, service);
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
    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, TagService service) throws ServletException, IOException {
        List<Tag> tags = service.findAll();

        req.setAttribute("tags", tags);
        getServletContext().getRequestDispatcher("/tags.jsp").forward(req, resp);
    }

    private void addTag(HttpServletRequest req, HttpServletResponse resp, TagService service) throws ServletException, IOException {
        //recuperamos los valores del formulario
        String description = req.getParameter("description");
        //valores con try-catch
        String idStr;
        try {
            idStr = req.getParameter("idTag");
        } catch (NullPointerException e) {
            idStr = "";
        }
        long id;
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            id = 0L;
        }

        //crea un tag que recibe cada valor
        Tag tag = getTagInfo(description, id);

        //llama al service para pasarle el tag
        service.add(tag);
    }


    private void deleteTag(HttpServletRequest req, HttpServletResponse resp, TagService service) throws ServletException, IOException {
        //recuperamos el id del tag
        String idStr;
        try {
            idStr = req.getParameter("idTag");
        } catch (NullPointerException e) {
            idStr = "";
        }
        long id;
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            id = 0L;
        }
        //se pasa la id al service
        service.delete(id);
        //devuelve el listado de usuarios
        this.defaultAction(req, resp, service);
    }

    private void editTagGet(HttpServletRequest req, HttpServletResponse resp, TagService service) throws ServletException, IOException {
        //recuperamos el id del tag
        String idStr;
        try {
            idStr = req.getParameter("idTag");
        } catch (NullPointerException e) {
            idStr = "";
        }
        long id;
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            id = 0L;
        }
        //se llama al servicio para buscar al tag por id y se guarda
        Tag tag = new Tag();
        Optional<Tag> o = service.findById(id);
        tag = o.get();

        //mandamos el tag al jsp
        req.setAttribute("tag", tag);

        //redireccionamos al formulario para editar
        String jspEdit = "/WEB-INF/pages/dashboard/tags/editTag.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, resp);
    }

    private static Tag getTagInfo(String description,long id) {
        Tag tag = new Tag();
        tag.setTagID(id);
        tag.setDesc(description);
        return tag;
    }
}
