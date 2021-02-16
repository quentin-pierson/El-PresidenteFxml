module com.esgi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires jackson.core.asl;
    requires jackson.mapper.asl;

    opens com.esgi to javafx.fxml;
    exports com.esgi;
}