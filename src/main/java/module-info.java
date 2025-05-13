module com.example.clubprojava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.clubprojava to javafx.fxml;
    exports com.example.clubprojava;
    exports com.example.clubprojava.controller;
    opens com.example.clubprojava.controller to javafx.fxml;
}