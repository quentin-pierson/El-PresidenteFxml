module com.esgi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.esgi to javafx.fxml;
    exports com.esgi;
}