package com.mycompany.libraryprogram.mvc.controller;

import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.model.service.adminService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //checkin the session if already login then to dashboar else if not login then login form

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        admin user = (admin) req.getSession().getAttribute("user");
        if (user != null) {
            resp.sendRedirect("./dashboard");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            adminService service = new adminService();
            Map<String, String> errors = new HashMap<>();
            admin user = service.login(email, password, errors);
            
            if (errors.size() > 0) {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("./dashboard");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
