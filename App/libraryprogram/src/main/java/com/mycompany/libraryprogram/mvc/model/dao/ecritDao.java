package com.mycompany.libraryprogram.mvc.model.dao;
import com.mycompany.libraryprogram.mvc.model.entity.ecrit;
import com.mycompany.libraryprogram.mvc.utils.JDBCUtils;
import java.io.*;
import java.sql.*;
public class ecritDao {
    //CRUD
    public static void createEcrit(ecrit ec) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO `ecrit` (`ISSN`, `Num`) VALUES(?,?)";

        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setInt(1, ec.getIssn_e());
            ps.setInt(2, ec.getId_au());
          
            
            // Step 3: Execute the query or update query
            ps.executeUpdate();
            System.out.println("result is =" + result);

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
    }
    //Queriers
}
