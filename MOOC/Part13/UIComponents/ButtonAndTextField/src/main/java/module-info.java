module com.example.buttonandtextfield {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonandtextfield to javafx.fxml;
    exports com.example.buttonandtextfield;
}