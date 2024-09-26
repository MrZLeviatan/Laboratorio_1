package com.programacion3.laboratorio_1.View;

import com.programacion3.laboratorio_1.Controller.LoggedController;
import com.programacion3.laboratorio_1.Main;
import com.programacion3.laboratorio_1.Model.ClubXd;
import com.programacion3.laboratorio_1.Model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    LoggedController loggedController;

    @FXML
    private void initialize(){
        loggedController = new LoggedController();
    }


    /**
     * Enter button executable event.
     * @param event
     * @throws IOException
     */
    @FXML
    void eventoIngresar(ActionEvent event) throws IOException {

        if (verificarCampo()){
            abrirVentanaSegunTipo(event);
        }
    }


    /**
     * General method which shows all the logging possibilities for the user.
     * @throws IOException
     */
    private void abrirVentanaSegunTipo(ActionEvent event) throws IOException {

        if (verificarCampo()){

            int opciones = loggedController.autentificador(usernameField.getText(), passwordField.getText());

            switch (opciones){

                case 1: cambiarVentana("/PlataformaApp/View/PublicadorGeneral.fxml",event);
                        break;

                case 2: cambiarVentana("/PlataformaApp/View/AdministradorGeneral.fxml",event);
                        break;

                case 3: cambiarVentana("GeneralMiembro.fxml",event);
                        break;

                case 0: mostrarMensaje("Error Al Iniciar Sesion","Error con los datos","El Usuario"+
                        "o Contraseña no han sido registrados", Alert.AlertType.ERROR);
                        break;
            }
        }
    }


    /**
     * Method to verify if the fields are well established.
     */
    private boolean verificarCampo() {
        String mensaje = "";
        if (usernameField.getText().isEmpty())
            mensaje += "Ingrese el campo de UserName\n";
        if (passwordField.getText().isEmpty()) {
            mensaje += "Ingrese el campo de Password\n";
        }
        if (mensaje==""){
            return true;
        }else {
            mostrarMensaje("Datos incorrectos","Datos invalidos",mensaje, Alert.AlertType.ERROR);
            return false;
        }
    }


    /**
     * Method to display the message according to its characteristics.
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }


    /**
     * Established method to change the window.
     * @param nombreFxml
     * @throws IOException
     */
    public void cambiarVentana(String nombreFxml,ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(nombreFxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Obtener la referencia a la ventana actual
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close(); // Cerrar la ventana actual

        // Abrir la nueva ventana
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}





