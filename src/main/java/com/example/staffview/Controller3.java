package com.example.staffview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller3 implements Initializable {
    @FXML
    private TableView<RegisteredStudent> StudentTableView;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<RegisteredStudent, String> tcMatricNo;

    @FXML
    private TableColumn<RegisteredStudent, String> tcName;

    @FXML
    private TextField tfCourseCode;

    @FXML
    private TextField tfOcc;


    ObservableList<RegisteredStudent> RegisteredStudentList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resource) {


        }
        public void handlebtnSearch(){
            RegisteredStudentList.clear();

            tcMatricNo.setCellValueFactory(new PropertyValueFactory<>("MatricNo"));
            tcName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            System.out.println("haha");
            try {

                String cc = tfCourseCode.getText();
                String occ = tfOcc.getText();
                String keywords = cc+"_"+occ;
                Class.forName("com.mysql.cj.jdbc.Driver");
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                java.sql.Statement sqlStatement = conn.createStatement();
                String sql = "";
                sql = "SELECT * FROM "+keywords+";";
                ResultSet results = sqlStatement.executeQuery(sql);
                while (results.next()) {
                    // start grabbing data
                /*String matric_number = results.getString().toUpperCase();
                System.out.print(matric_number+" ");
                String name = results.getString().toUpperCase();
                System.out.println(name);*/
                    RegisteredStudentList.add(new RegisteredStudent(

                            results.getString("matricno"),
                            results.getString("name")));

                    StudentTableView.setItems(RegisteredStudentList);
                }
                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }







