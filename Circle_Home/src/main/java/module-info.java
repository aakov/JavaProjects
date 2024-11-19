module com.example.circle_home {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.circle_home to javafx.fxml;
    exports com.example.circle_home;
}