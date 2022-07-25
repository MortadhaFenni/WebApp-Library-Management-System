package com.mycompany.libraryprogram.mvc.model.dao;

import com.mycompany.libraryprogram.mvc.model.entity.ecrit;
import com.mycompany.libraryprogram.mvc.model.entity.livre;
import com.mycompany.libraryprogram.mvc.utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bookDao {
    
    //CRUD
    public static void AddLivre(livre book, int nauteur) throws ClassNotFoundException {
        String INSERT_LIVRE_SQL = "INSERT INTO livre"
                + " VALUES "
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_LIVRE_SQL);
            ps.setInt(1,book.getIssn());
            ps.setString(2,book.getTitre());
            ps.setString(3,book.getResume());
            ps.setInt(4,book.getNb_pages());
            ps.setInt(5,book.getGenres());
            ps.setInt(6,book.getS_genre());
            ps.setString(7,book.getAvatar());
            ps.setString(8,book.getFile());
            ps.setInt(9,book.getUserId());
            ps.setDate(10, new java.sql.Date(book.getCreatedAt().getTime()) );
            
            System.out.println(ps);
            // Step 3: Execute the query or update query
            result = ps.executeUpdate();
            System.out.println("result is =" + result);
            
            ecrit ec=new ecrit(book.getIssn(),nauteur);
            try {
                ecritDao.createEcrit(ec);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
    }

    //QUERIES
    //check if thers's an user with same email
    /*public static livre getLivreByIssn(int issn) throws ClassNotFoundException {
        livre book_found = new livre();
        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement ps = connection
                    .createStatement();
            
            String query="SELECT * FROM livre where issn ="+issn+" ?";
            Boolean b;
            
            ResultSet rs = ps.executeQuery(query);
            b=rs.next();
            book_found = new livre(rs.getInt("issn"), rs.getString("titre"), rs.getString("resume"), rs.getInt("nb_page"), rs.getInt("genre"),rs.getInt("s_genre"),rs.getString("avatar"),rs.getString("file"));

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return book_found;
    }*/
    
    
    public static ArrayList<livre> getAllBooks(String titre) throws ClassNotFoundException {
        ArrayList<livre> bookList = new ArrayList<livre>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = JDBCUtils.getConnection();
            String query = "SELECT * FROM livre WHERE titre LIKE '"+titre+"%'";

            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            livre book;

            while (rs.next()) {
                book = new livre(rs.getInt("issn"), rs.getString("titre"), rs.getString("resume"), rs.getInt("nb_page"), rs.getInt("genre"),rs.getInt("s_genre"),rs.getString("avatar"),"",rs.getInt("added_by"));
                bookList.add(book);
            }

        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
        }

        return bookList;
    }
    
    public static ArrayList<livre> getAllBooksByAdmin(int id) throws ClassNotFoundException {
        ArrayList<livre> bookList = new ArrayList<livre>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = JDBCUtils.getConnection();
            String query = "SELECT * FROM livre WHERE added_by='"+id+"'";

            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            livre book;

            while (rs.next()) {
                book = new livre(rs.getInt("issn"), rs.getString("titre"), rs.getString("resume"), rs.getInt("nb_page"), rs.getInt("genre"),rs.getInt("s_genre"),rs.getString("avatar"),"",rs.getInt("added_by"));
                bookList.add(book);
            }

        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
        }

        return bookList;
    }
}
