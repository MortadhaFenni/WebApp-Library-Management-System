package com.mycompany.libraryprogram.mvc.model.dao;

import java.sql.*;
import com.mycompany.libraryprogram.mvc.model.entity.admin;
import com.mycompany.libraryprogram.mvc.utils.JDBCUtils;

public class adminDao {

    //CRUD
    public static void CreateAdmin(admin user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO `admins` (`name`, `email`, `password`) VALUES(?,?,?)";

        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
          
            
            // Step 3: Execute the query or update query
            ps.executeUpdate();
            System.out.println("result is =" + result);

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
    }

    //QUERIES
    //check if thers's an user with same email
    public static admin getAdminByEmail(String email) throws ClassNotFoundException {
        admin admin_user;
        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement ps =(Statement) connection.createStatement();
            
            String query="SELECT * FROM admins WHERE email='"+email+"'";
            Boolean b;
            
            ResultSet rs = (ResultSet) ps.executeQuery(query);
            b=rs.next();
            System.out.println("reeeees =" + b);
            admin_user = new admin(rs.getString("name"),rs.getString("email"),rs.getString("password"));
            admin_user.setId(rs.getInt("id"));
            return admin_user;

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
            return null;
        }
    }

}
