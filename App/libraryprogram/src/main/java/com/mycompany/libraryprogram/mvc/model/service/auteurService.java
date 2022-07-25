package com.mycompany.libraryprogram.mvc.model.service;

import com.mycompany.libraryprogram.mvc.model.dao.auteurDao;
import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import java.util.ArrayList;
import java.util.Map;

public class auteurService {

    public auteur addNewAuteur(auteur author, Map<String, String> errors) throws ClassNotFoundException {
        String fname = author.getNom().trim();
        if (fname.length() == 0) {
            errors.put("firstname", "Firstname is required");
        } else if (fname.length() < 3) {
            errors.put("firstname", "At least 3 letters required for firstname");
        }
        String lname = author.getPrenom().trim();
        if(lname.length() == 0){
          errors.put("firstname", "Firstname is required");
        } else if (fname.length() < 3) {
            errors.put("firstname", "At least 3 letters required for firstname");
        }
        String date=(String)author.getDate_naissance().toString();
        if(date == null){
            errors.put("datebirth", "datebirth is required");
        }
        if (errors.size() > 0) {
            return null;
        }
        int id=auteurDao.CreateAuteur(author);
        auteur b=new auteur(id,author.getNom(),author.getPrenom(),author.getDate_naissance(),author.getAvatar());
        return b;
    }
    
    public auteur getAuteurById(int id) throws ClassNotFoundException{
        auteur a=auteurDao.getAuteur(id);
        return a;
    }
    
}
