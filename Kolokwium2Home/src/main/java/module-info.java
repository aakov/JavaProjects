module com.example.kolokwium2home {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kolokwium2home to javafx.fxml;
    exports com.example.kolokwium2home;
}