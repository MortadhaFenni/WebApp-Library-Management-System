package com.mycompany.libraryprogram.mvc.controller;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebFilter(urlPatterns = { "/dashboard", "/add-auteur", "/show-auteur", "/add-book", "/view-all-books","/show-books"})
public class LoginCheckFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //getsession is avilable in HttpServletRequest not in servletrequest so
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        //check if user login or not
        admin user=(admin) request.getSession().getAttribute("user");
        
        if(user== null){//when acces somthin without login
            response.sendRedirect("./login");
            return;
        }
        chain.doFilter(request, response);
    }
    
}
