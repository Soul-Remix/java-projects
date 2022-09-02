module com.example.buttonandlabel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonandlabel to javafx.fxml;
    exports com.example.buttonandlabel;
}