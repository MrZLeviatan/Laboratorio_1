module com.programacion3.laboratorio_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.programacion3.laboratorio_1 to javafx.fxml;
    exports com.programacion3.laboratorio_1;
}