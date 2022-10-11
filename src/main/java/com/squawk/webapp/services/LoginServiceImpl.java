package com.squawk.webapp.services;

import com.squawk.webapp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceImpl implements LoginService{
    @Override
    public Optional<User> getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Optional<User>) session.getAttribute("user");
    }
}
