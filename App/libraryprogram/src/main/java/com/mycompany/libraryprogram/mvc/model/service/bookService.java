package com.mycompany.libraryprogram.mvc.model.service;

import com.mycompany.libraryprogram.mvc.model.dao.adminDao;
import java.io.*;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import com.mycompany.libraryprogram.mvc.model.entity.livre;
import com.mycompany.libraryprogram.mvc.model.dao.bookDao;
import com.mycompany.libraryprogram.mvc.model.dao.auteurDao;
import java.util.*;
import org.mindrot.jbcrypt.BCrypt;

public class bookService {

    public livre addNewLivre(livre book,int auteur_id ,Map<String, String> errors) throws IOException, ClassNotFoundException {
        if (String.valueOf(book.getIssn()).trim().length() == 0) {
            errors.put("issn", "Issn is mandatory");
        } else if (String.valueOf(book.getIssn()).trim().length() !=8) {
            errors.put("issn", "8 numbers are required");
        }

        if (book.getTitre().trim().length() == 0) {
            errors.put("tytre", "Titre is mandatory");
        }

        if (book.getResume().trim().length() == 0) {
            errors.put("resume", "Resume is mandatory");
        }

        if (String.valueOf(book.getNb_pages()).trim().length() == 0) {
            errors.put("nb_page", "Nb_page is mandatory");
        }
        
        if (String.valueOf(book.getGenres()).trim().length() == 0) {
            errors.put("genre", "genre is mandatory");
        }
        
        if (String.valueOf(book.getS_genre()).trim().length() == 0) {
            errors.put("s_genre", "s_genre is mandatory");
        }
        
        if (String.valueOf(auteur_id).trim().length() == 0) {
            errors.put("auteur", "Auteur is mandatory");
        }
        
        /*livre book = livreDao.getLivreByIssn(issn); //check existence of book
        if (book != null) {
            errors.put("issn", "This issn is already added");
        }
        
        auteur aut = auteurDao.getAuteurByNum(nauteur); //check existence of autor
        if (aut == null) {
            errors.put("auteur", "This auteur doesn't exist");
        }*/

        if (errors.size() > 0) {
            return null;
        }
 
        
        bookDao.AddLivre(book,auteur_id);

        return book;
    }
    
    public List<livre> getbooks(int admin_id) throws ClassNotFoundException{
        return bookDao.getAllBooksByAdmin(admin_id);
    }
    
    public List<livre> getbooksbytitre(String titre) throws ClassNotFoundException{
        return bookDao.getAllBooks(titre);
    }
}
