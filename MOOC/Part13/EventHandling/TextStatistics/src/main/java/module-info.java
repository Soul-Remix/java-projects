module com.example.textstatistics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textstatistics to javafx.fxml;
    exports com.example.textstatistics;
}