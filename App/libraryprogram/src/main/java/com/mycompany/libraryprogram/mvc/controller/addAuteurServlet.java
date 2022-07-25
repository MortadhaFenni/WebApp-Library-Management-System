package com.mycompany.libraryprogram.mvc.controller;

import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import com.mycompany.libraryprogram.mvc.model.service.auteurService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/add-auteur")
public class addAuteurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/Views/auteurForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            // 1. read inputs from request
            String fname = req.getParameter("firstname");
            String lname = req.getParameter("lastname");
            String date=req.getParameter("datebirth");
            //Date date_naissance=new SimpleDateFormat("yyyy-mm-dd").parse(date);
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            String avatar = req.getParameter("avatar");
            auteur author = new auteur();
            author.setNom(lname);
            author.setPrenom(fname);
            author.setDate_naissance(sqlDate);
            author.setAvatar(avatar);
            admin user = (admin) req.getSession().getAttribute("user");//ensijamais malgre on a verifier login deja
            //send those info to service to check if there's no errors and return auteur object
            auteurService service=new auteurService();
            Map<String, String> errors = new HashMap<>();
            author=service.addNewAuteur(author,errors);
            
            if(errors.size()>0){
                req.setAttribute("errors",errors);
                req.getRequestDispatcher("/WEB-INF/Views/auteurForm.jsp").forward(req, resp);
            }else{
                req.setAttribute("auteur", author);
                resp.sendRedirect("./view-auteur-details?id="+author.getId());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addAuteurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
