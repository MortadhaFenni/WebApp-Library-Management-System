package com.mycompany.libraryprogram.mvc.controller;

import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import com.mycompany.libraryprogram.mvc.model.service.auteurService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/view-auteur-details")
public class ViewAuteurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String input = req.getParameter("id");
            if (input == null) {
                resp.sendRedirect("./");
                return;
            }
            Integer id = new Integer(input);
            auteurService service = new auteurService();
            auteur b=service.getAuteurById(id);
            
            req.setAttribute("auteur", b);
            req.getRequestDispatcher("/WEB-INF/Views/show-auteur.jsp").forward(req, resp);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAuteurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
