module com.programacion3.laboratorio_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;
    requires java.xml.crypto;
    requires java.logging;


    opens com.programacion3.laboratorio_1 to javafx.fxml;
    exports com.programacion3.laboratorio_1;

    opens com.programacion3.laboratorio_1.View to javafx.fxml;
    exports com.programacion3.laboratorio_1.View;

    exports com.programacion3.laboratorio_1.Model;

    opens com.programacion3.laboratorio_1.Controller to javafx.fxml;
    exports com.programacion3.laboratorio_1.Controller;
}