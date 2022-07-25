package com.mycompany.libraryprogram.mvc.model.service;

import com.mycompany.libraryprogram.mvc.model.dao.adminDao;
import java.io.*;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import java.util.*;
import org.mindrot.jbcrypt.BCrypt;

public class adminService {

    public admin registerAdmin(String name, String email, String password, String cPassword, Map<String, String> errors) throws IOException, ClassNotFoundException {
        if (name.trim().length() == 0) {
            errors.put("name", "Name is mandatory");
        } else if (name.trim().length() < 3) {
            errors.put("name", "At least 3 letters are required");
        }

        if (email.trim().length() == 0) {
            errors.put("email", "Email address is mandatory");
        }

        if (password.trim().length() == 0) {
            errors.put("password", "Password is mandatory");
        }

        if (password.equals(cPassword) == false) {
            errors.put("cPassword", "Passwords do not match");
        }

        admin user = adminDao.getAdminByEmail(email);
        if (user != null) {
            errors.put("email", "This email is already registered with us");
        }

        if (errors.size() > 0) {
            return null;
        }

        password = BCrypt.hashpw(password, BCrypt.gensalt(12));

        user = new admin(name, email, password);
        adminDao.CreateAdmin(user);

        return user;
    }

    public admin login(String email, String password, Map<String, String> errors) throws ClassNotFoundException {
        if (email.trim().length() == 0) {
            errors.put("email", "Email address is mandatory");
        }

        if (password.trim().length() == 0) {
            errors.put("password", "Password is mandatory");
        }

        if(errors.size() > 0) {
            return null;
        }

        
        admin user = adminDao.getAdminByEmail(email);

        if (user == null) {
            errors.put("email", "Invalid email/password");
        } else {
            boolean result = BCrypt.checkpw(password, user.getPassword());
            if (result == false) {
                errors.put("email", "Invalid email/password");
            }
        }

        if (errors.size() > 0) {
            return null;
        }

        return user;
    }
}
