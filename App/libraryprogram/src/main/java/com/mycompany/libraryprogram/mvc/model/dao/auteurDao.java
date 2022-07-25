package com.mycompany.libraryprogram.mvc.model.dao;

import com.mycompany.libraryprogram.mvc.model.entity.auteur;
import com.mycompany.libraryprogram.mvc.utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;

public class auteurDao {

    //CRUD
    public static int CreateAuteur(auteur author) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO `auteur` (`nom`, `prenom`, `date_naissance`) VALUES(?,?,?)";

        //trying to id 
        int primkey = 0;
        String columnNames[] = new String[]{"id"};

        
        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL, columnNames);
            ps.setString(1, author.getNom());
            ps.setString(2, author.getPrenom());
            ps.setDate(3, author.getDate_naissance());

            // Step 3: Execute the query or update query
            if (ps.executeUpdate() > 0) {
                // Retrieves any auto-generated keys created as a result of executing this Statement object
                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    primkey = generatedKeys.getInt(1);
                }
            }
            System.out.println("Record updated with id = " + primkey);
            
            return primkey;

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
            return -1;
        }
    }
    //QUERIES
    public static auteur getAuteur(int id) throws ClassNotFoundException{
        auteur author;
        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement ps =(Statement) connection.createStatement();
            
            String query="SELECT * FROM auteur WHERE num='"+id+"'";
            Boolean b;
            
            ResultSet rs = (ResultSet) ps.executeQuery(query);
            b=rs.next();
            System.out.println("reeeees =" + b);
            author = new auteur(rs.getString("nom"),rs.getString("prenom"),rs.getDate("date_naissance"),rs.getString("avatar"));
            return author;

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
            return null;
        }
    }
    
     public static ArrayList<auteur> getAllAuteurs() throws ClassNotFoundException {
        ArrayList<auteur> auteurList = new ArrayList<auteur>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = JDBCUtils.getConnection();
            String query = "SELECT * FROM auteur";

            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            auteur author;

            while (rs.next()) {
                author = new auteur(rs.getInt("num"), rs.getString("nom"), rs.getString("prenom"));
                auteurList.add(author);
            }

        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
        }

        return auteurList;
    }
}
