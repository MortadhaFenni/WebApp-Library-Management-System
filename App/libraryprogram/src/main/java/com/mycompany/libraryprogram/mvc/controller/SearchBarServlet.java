package com.mycompany.libraryprogram.mvc.controller;

import com.mycompany.libraryprogram.mvc.model.service.bookService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/search")
public class SearchBarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //req.getRequestDispatcher("/WEB-INF/Views/show-search.jsp").forward(req, resp);
        String search = req.getParameter("searching").toString();
        String searchby = req.getParameter("searchingby").toString();
        try {
            bookService a = new bookService();
            req.setAttribute("books", a.getbooksbytitre(search));
            req.setAttribute("titresearch", search);
            req.getRequestDispatcher("/WEB-INF/Views/show-search.jsp").forward(req, resp);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchBarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //resp.sendRedirect("./show-search.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String search = req.getParameter("searching").toString();
        String searchby = req.getParameter("searchingby").toString();
        if (searchby.equals("Book")) {
            try {
                bookService a = new bookService();
                req.setAttribute("books", a.getbooksbytitre(search));
                req.setAttribute("titresearch", search);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SearchBarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            req.getRequestDispatcher("/WEB-INF/Views/show-search.jsp").forward(req, resp);
            //resp.sendRedirect("./show-search.jsp");

        } else {
            req.getRequestDispatcher("/WEB-INF/Views/show-search.jsp").forward(req, resp);
        }
    }
}
