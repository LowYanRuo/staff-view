package com.example.staffview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 600, 400);


        Parent root = FXMLLoader.load(getClass().getResource("registered-view.fxml"));
        Scene scene = new Scene(root);
        //Image icon = new Image(("UM logo.png"));
        //stage.getIcons().add(icon) ;
        stage.setTitle("|View Modules");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}