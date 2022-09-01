module com.example.firstapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstapplication to javafx.fxml;
    exports com.example.firstapplication;
}