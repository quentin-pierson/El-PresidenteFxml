module com.esgi {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires javafx.media;
    opens com.esgi to javafx.fxml;
    exports com.esgi;
    exports com.esgi.models;
    exports com.esgi.models.Calamities;

    opens com.esgi.models;
    opens com.esgi.models.Calamities;
    opens com.esgi.Sound;
}