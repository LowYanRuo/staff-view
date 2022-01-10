package com.example.staffview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController implements Initializable {
    @FXML
    public MenuButton mbNameofTutor;
    @FXML
    private TableColumn<module,String> coursecode1;
    @FXML
    private TableColumn<module,String> coursecode2;
    @FXML
    private TableColumn<module,String> modulename;
    @FXML
    private TableColumn<module,Integer> occurence;
    @FXML
    private TableColumn<module,String> activity;
    @FXML
    private TableColumn<module,String> day;
    @FXML
    private TableColumn<module,Integer> time1;
    @FXML
    private TableColumn<module,Integer> time2;
    @FXML
    private TableColumn<module,Integer> target;
    @FXML
    private TableColumn<module,Integer> actual;
    @FXML
    private TableColumn<module,Integer> credits;
    @FXML
    private TableColumn<module,String> tutor;
    @FXML
    private TableView<module> tableview;
    @FXML
    private TableColumn <module, Integer> courseid;
    @FXML
    private TextField tfentername;



    private Stage stage;
    private Scene scene;
    private Parent root;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    module module = null;

    ObservableList<module> moduleList = FXCollections.observableArrayList();

    public void refreshTable(){

        try {
            moduleList.clear();

            query = "SELECT * FROM modules";  //change 'modules' to your own table name
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                moduleList.add(new module(

                        resultSet.getString("id"),
                        resultSet.getString("CourseCode1"),
                        resultSet.getString("CourseCode2"),
                        resultSet.getString("ModuleName"),
                        resultSet.getInt("Occurrence"),
                        resultSet.getString("Activity"),
                        resultSet.getString("Dayweek"),
                        resultSet.getInt("Time1"),
                        resultSet.getInt("Time2"),
                        resultSet.getInt("Target"),
                        resultSet.getInt("Actual"),
                        resultSet.getInt("Credits"),
                        resultSet.getString("Tutor")));


                tableview.setItems(moduleList);

            }


        } catch (SQLException e) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }

    public void loadDate(){

        connection = database.getConnect();
        refreshTable();



        courseid.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        coursecode1.setCellValueFactory(new PropertyValueFactory<>("CourseCode1"));
        coursecode2.setCellValueFactory(new PropertyValueFactory<>("CourseCode2"));
        modulename.setCellValueFactory(new PropertyValueFactory<>("ModuleName"));
        occurence.setCellValueFactory(new PropertyValueFactory<>("Occurrence"));
        activity.setCellValueFactory(new PropertyValueFactory<>("Activity"));
        day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        time1.setCellValueFactory(new PropertyValueFactory<>("Time1"));
        time2.setCellValueFactory(new PropertyValueFactory<>("Time2"));
        target.setCellValueFactory(new PropertyValueFactory<>("Target"));
        actual.setCellValueFactory(new PropertyValueFactory<>("Actual"));
        credits.setCellValueFactory(new PropertyValueFactory<>("Credits"));
        tutor.setCellValueFactory(new PropertyValueFactory<>("Tutor"));



    }

}