package com.squawk.webapp.controllers;

import com.squawk.webapp.models.User;
import com.squawk.webapp.services.UserService;
import com.squawk.webapp.services.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "users", urlPatterns = {"/users"})
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
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                case "update":
                    this.addUser(req,resp,service);
                    this.updateUser(req,resp,service);
                    getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
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
        //valores con try-catch
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
        //recuperamos el id del usuario
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
        //se pasa la id al service
        service.delete(id);
        //devuelve el listado de usuarios
        this.defaultAction(req, resp, service);
    }

    private void editUserGet(HttpServletRequest req, HttpServletResponse resp, UserService service) throws ServletException, IOException {
        //recuperamos el id del usuario
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
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //verifica si ha iniciado sesion
        Optional<User> optionalUser = service.login(email, password);

        if (optionalUser.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser);
        }
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
