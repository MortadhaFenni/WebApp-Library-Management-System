package com.mycompany.libraryprogram.mvc.controller;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //pour ne pas verifier a chaque fois login dans diiferent pages
        // on ajout servlet filtre et definit tout  les servlet qui besion
        //de veriierlogin dans le cas ou il tap le lien direct dans browser
        /*
        //check if user login or not
        admin user=(admin) req.getSession().getAttribute("user");
        
        if(user== null){//when acces somthin without login
            resp.sendRedirect("./login");
            return;
        }
        */
        req.getRequestDispatcher("/WEB-INF/Views/dashboard.jsp").forward(req, resp);
    }
    
}
