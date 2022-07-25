package com.mycompany.libraryprogram.mvc.controller;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.model.service.bookService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/view-all-books")
public class BooksAdminServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            admin user = (admin) req.getSession().getAttribute("user");
            bookService service = new bookService();
            req.setAttribute("books", service.getbooks(user.getId()));
            req.getRequestDispatcher("/WEB-INF/Views/show-books.jsp").forward(req, resp);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BooksAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
