package com.squawk.webapp.filters;

import com.squawk.webapp.models.User;
import com.squawk.webapp.services.LoginService;
import com.squawk.webapp.services.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/profile", "/submit", "/profile.jsp", "/submit.jsp"})
public class ValidateLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceImpl();
        Optional<User> userOptional = service.getUser((HttpServletRequest) servletRequest);

        try {
            if (userOptional.isPresent()) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }catch (NullPointerException e){
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, ¡necesitas iniciar sesión para ver esta página!");
        }
    }
}


