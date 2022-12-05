package com.squawk.webapp.controllers;

import com.squawk.webapp.models.User;
import com.squawk.webapp.services.UserService;
import com.squawk.webapp.services.UserServiceImpl;
import com.squawk.webapp.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "users", urlPatterns = {"/users"})
@MultipartConfig(
        location = "G:\\Juan Utp\\Ciclo VI\\Integrador_I\\Avance_Squawk_Maven\\src\\main\\webapp\\profile_pictures",
        fileSizeThreshold = 1024 * 1024,  //  1 MB
        maxFileSize = 1024 * 1024 * 10,   // 10 MB
        maxRequestSize = 1024 * 1024 * 11 // 11 MB
)
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UserService service = new UserServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editUserGet(req, resp, service);
                    break;
                case "delete":
                    this.deleteUser(req, resp, service);
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
        UserService service = new UserServiceImpl(conn);

        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                case "edit":
                    this.addUser(req, resp, service);
                    this.defaultAction(req,resp,service);
                    break;
                case "sign-up":
                    this.addUser(req,resp,service);
                    getServletContext().getRequestDispatcher("/index").forward(req, resp);
                    break;
                case "update":
                    this.addUser(req,resp,service);
                    this.updateUser(req,resp,service);
                    break;
                case "updateProfilePicture":
                    this.updateProfile(req,resp,service);
                    this.updateUser(req,resp,service);
                    break;
                case "editPicture":
                    this.updateProfile(req,resp,service);
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
    private void defaultAction(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        List<User> users = service.findAll();

        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //recuperamos los valores del formulario
        String name = req.getParameter("nickname");
        String birthdayStr = req.getParameter("birthday");
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //obtener id
        long id = getId(req);
        //valores con try-catch
        int type;
        try {
            type = Integer.parseInt(req.getParameter("type"));
        } catch (NumberFormatException e) {
            type = 1;
        }

        //crea un usuario que recibe cada valor
        User user = getUserInfo(name, birthday, email, password, id, type);

        //llama al service para pasarle el usuario
        service.add(user);
    }


    private void deleteUser(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //obtener id
        long id = getId(req);
        //se pasa la id al service
        service.delete(id);
        //devuelve el listado de usuarios
        this.defaultAction(req, resp, service);
    }

    private void updateProfile(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //obtener id
        long id = getId(req);
        //recuperamos la imagen
        try {
            Part img = req.getPart("img");
            img.write(Util.getFileName(img));//se sube la imagen al proyeto
            img.write(getServletContext().getRealPath("\\" + "profile_pictures"+  File.separator + Util.getFileName(img)));//se sube la imagen al servidor

            //se crea la direccion de la imagen
            String imgPath = getServletContext().getContextPath()+ "\\" + "profile_pictures"+ File.separator + Util.getFileName(img);

            //Se sube el directorio a la base de datos
            service.uploadPicture(id,imgPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void editUserGet(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //obtener id
        long id = getId(req);
        //se llama al servicio para buscar al usuario por id y se guarda
        User user = new User();
        Optional<User> o = service.findById(id);
        user = o.get();

        //mandamos el usuario al jsp
        req.setAttribute("user", user);

        //redireccionamos al formulario para editar
        String jspEdit = "/WEB-INF/pages/dashboard/users/editUser.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //obtener id
        long id = getId(req);
        //verifica si ha iniciado sesion
        Optional<User> optionalUser = service.findById(id);

        if (optionalUser.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser);
        }

        getServletContext().getRequestDispatcher("/profile?id="+id).forward(req, resp);
    }

    private static long getId(HttpServletRequest req) {
        String idStr;
        try {
            idStr = req.getParameter("idUser");
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


    private static User getUserInfo(String name, LocalDate birthday, String email, String password, long id, int type) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(1);
        user.setType(type);
        user.setCreationDate(LocalDate.now());
        return user;
    }
}
