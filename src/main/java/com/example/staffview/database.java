package com.example.staffview;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class database {
    public static Connection getConnect (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffmodules", "root", "root"); //connect to your own database
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  connection;
    }

}
