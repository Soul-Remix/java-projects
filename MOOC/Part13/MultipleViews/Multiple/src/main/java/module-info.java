module com.example.multiple {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.multiple to javafx.fxml;
    exports com.example.multiple;
}