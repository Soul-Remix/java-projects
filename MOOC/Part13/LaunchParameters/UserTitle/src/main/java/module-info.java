module com.example.usertitle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.usertitle to javafx.fxml;
    exports com.example.usertitle;
}