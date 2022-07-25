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

@WebServlet("/register")
public class RegisterServlet_Admin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //-- login
        admin user = (admin) req.getSession().getAttribute("user");
        if (user != null) {
            resp.sendRedirect("./dashboard");
            return;
        }
        //--
        req.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            // 1. read inputs from request
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String cPassword = req.getParameter("c_password");

            // 2. make use of a model function
            adminService service = new adminService();
            Map<String, String> errors = new HashMap<>();
            admin user = service.registerAdmin(name, email, password, cPassword, errors);

            if (errors.size() > 0) {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("./dashboard");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
