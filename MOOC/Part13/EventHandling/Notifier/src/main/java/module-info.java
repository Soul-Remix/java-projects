module com.example.notifier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.notifier to javafx.fxml;
    exports com.example.notifier;
}