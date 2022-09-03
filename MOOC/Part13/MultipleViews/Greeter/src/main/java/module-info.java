module com.example.greeter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.greeter to javafx.fxml;
    exports com.example.greeter;
}