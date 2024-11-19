module com.example.poprawka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.poprawka to javafx.fxml;
    exports com.example.poprawka;
}