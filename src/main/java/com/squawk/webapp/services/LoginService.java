package com.squawk.webapp.services;

import com.squawk.webapp.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
public interface LoginService {
    Optional<User> getUser(HttpServletRequest request);
}
