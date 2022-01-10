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

import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller2 implements Initializable {
    @FXML
    private TableColumn<module, String> courseid;
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
    private TextField tfentername;

    ObservableList<module> moduleList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resource) {

        database connectNow = new database();
        Connection connectDB = connectNow.getConnect();

        String ModuleViewQuery = "SELECT id, CourseCode1,CourseCode2, ModuleName, Occurrence, Activity, Dayweek, Time1, Time2, Target, Actual, Credits, Tutor FROM modules";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ModuleViewQuery);

            while (queryOutput.next()){

                String ID = queryOutput.getString("id");
                String CourseCode1 = queryOutput.getString("CourseCode1");
                String CourseCode2 = queryOutput.getString("CourseCode2");
                String ModuleName = queryOutput.getString("ModuleName");
                Integer Occurrence = queryOutput.getInt("Occurrence");
                String Activity = queryOutput.getString("Activity");
                String Dayweek = queryOutput.getString("Dayweek");
                Integer Time1 = queryOutput.getInt("Time1");
                Integer Time2 = queryOutput.getInt("Time2");
                Integer Target = queryOutput.getInt("Target");
                Integer Actual = queryOutput.getInt("Actual");
                Integer Credits = queryOutput.getInt("Credits");
                String Tutor = queryOutput.getString("Tutor");

                moduleList.add(new module(ID, CourseCode1, CourseCode2, ModuleName, Occurrence, Activity, Dayweek, Time1, Time2, Target, Actual, Credits, Tutor));
            }

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

            tableview.setItems(moduleList);

            FilteredList<module> filteredData = new FilteredList<>(moduleList, b-> true);

            tfentername.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(module -> {

                    if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if(module.getTutor().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //means we found a match in Tutor
                    }else
                        return false; //no match found
                });
            });

            SortedList<module> sortedData = new SortedList<>(filteredData);

            //bind sorted result with tableview
            sortedData.comparatorProperty().bind(tableview.comparatorProperty());

            //Apply filtered and sorted data to the tableview
            tableview.setItems(sortedData);

        } catch(SQLException e){
            Logger.getLogger(Controller2.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}