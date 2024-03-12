module com.example.doga {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.doga to javafx.fxml;
    exports com.example.doga;
}