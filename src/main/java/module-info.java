module com.example.staffview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.staffview to javafx.fxml;
    exports com.example.staffview;
}