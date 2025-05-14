module com.example.clubprojava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.compiler;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    opens com.example.clubprojava to javafx.fxml;
    exports com.example.clubprojava;
    exports com.example.clubprojava.controller;
    opens com.example.clubprojava.controller to javafx.fxml;
    opens com.example.clubprojava.model to javafx.base;

    exports com.example.clubprojava.model;
    exports com.example.clubprojava.model.Enum;

}