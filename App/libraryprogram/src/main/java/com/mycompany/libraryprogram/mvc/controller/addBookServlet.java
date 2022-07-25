package com.mycompany.libraryprogram.mvc.controller;
import com.mycompany.libraryprogram.mvc.model.dao.auteurDao;
import com.mycompany.libraryprogram.mvc.model.dao.ecritDao;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import com.mycompany.libraryprogram.mvc.model.entity.ecrit;
import com.mycompany.libraryprogram.mvc.model.entity.livre;
import com.mycompany.libraryprogram.mvc.model.service.auteurService;
import com.mycompany.libraryprogram.mvc.model.service.bookService;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/add-book")
public class addBookServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            ArrayList<auteur> list=auteurDao.getAllAuteurs();
            req.setAttribute("auteurs", list);
            req.getRequestDispatcher("/WEB-INF/Views/bookForm.jsp").forward(req, resp);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // 1. read inputs from request
        
        /*System.out.println(" yaaaaaa"+str);
        String[] domaines=req.getParameterValues("domaine");
        for(int i=0;i<domaines.length;i++){
            System.out.println(" yaaaaaaw"+domaines[i]);
        }
        String domain=Arrays.toString(domaines);
        System.out.println(" yaaaaaa na"+domain);*/
        int issn=Integer.valueOf(req.getParameter("issn"));
        String titre = req.getParameter("titre");
        String resume = req.getParameter("resume");
        int nbpage=Integer.valueOf(req.getParameter("nbpages"));
        String str = req.getParameter("domaine");
        String avatar = req.getParameter("avatar");
        String file= req.getParameter("file");
        //---photo
        //Inserting Blob type
        /*
        final Part filePart = req.getPart("avatar");
        InputStream pdfFileBytes = null;
        pdfFileBytes = filePart.getInputStream();  // to get the body of the request as binary data
        final byte[] bytes = new byte[pdfFileBytes.available()];
        pdfFileBytes.read(bytes);  //Storing the binary data in bytes array.*/
        //---
        
        livre book = new livre();
        book.setIssn(issn);
        book.setTitre(titre);
        book.setResume(resume);
        book.setNb_pages(nbpage);
        book.setGenres(1);
        book.setS_genre(Integer.valueOf(str));
        book.setAvatar(avatar);
        book.setFile(file);
        /*int domaine=-1;
        switch (domaine){
            case "Arts": domaine=1; break;
            case "Animaux": domaine=2; break;
            case "Fiction": domaine=3; break;
            case "Science & Mathématiques": domaine=4; break;
            case "Économie & Finance": domaine=5; break;
            case "Fiction jeunesse":domaine=6; break;
            case "Histoire":domaine=7; break;
            case "Santé & Bien-être":domaine=8; break;
            case "Biographie":domaine=9; break;
            case "Sciences sociales": domaine=10; break;
            case "Manuel": domaine=11; break;
        }
        book.setGenres(domaine);*/
        //book.setS_genre(subgenre);
        
        //book.setAvatar(avatar);
        admin user = (admin) req.getSession().getAttribute("user");//ensijamais malgre on a verifier login deja
        
        book.setUserId(user.getId());
        int auteur_id=Integer.valueOf(req.getParameter("auteurID"));
        /*
        ecrit e=new ecrit(issn,auteur_id);
        */
        //send those info to service to check if there's no errors and return auteur object
        
        // 2. make use of a model function
        bookService service=new bookService();
        Map<String, String> errors = new HashMap<>();
        
        try {
            book=service.addNewLivre(book,auteur_id,errors);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(errors.size()>0){
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/WEB-INF/Views/bookForm.jsp").forward(req, resp);
        }else{
            req.setAttribute("auteur", book);
            resp.sendRedirect("./view-book-details?id="+book.getIssn()
            );
        }
        
        

        
    }
    
    
}
