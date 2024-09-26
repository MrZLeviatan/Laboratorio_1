package com.programacion3.laboratorio_1.View;

import com.programacion3.laboratorio_1.Controller.RegistroController;
import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Model.Administrador;
import com.programacion3.laboratorio_1.Model.Enum.TipoMiembro;
import com.programacion3.laboratorio_1.Model.UserName;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroAdminsController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField correoField;

    @FXML
    private ComboBox<TipoMiembro> tipoMiembroComboBox;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    RegistroController registroController;

    @FXML
    public void initialize() {

        registroController = new RegistroController();
    }

    @FXML
    private void handleRegistrarButtonAction() throws PersonaException {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (validarCampos(nombre, cedula, username,password)) {
            if (registroController.registroAdministrador(crearAdmin())){
                mostrarAlerta("Registro Exitoso", "El miembro " + nombre + " ha sido registrado");
                handleCancelButtonAction();
            }else{
                mostrarAlerta("Registro Fallido", "Ocurrio un error en el registro");

            }
        } else {
            mostrarAlerta("Error de Registro", "Por favor, rellena todos los campos correctamente.");
        }
    }

    public Administrador crearAdmin(){
        Administrador administrador = new Administrador();
        administrador.setNombre(nombreField.getText());
        administrador.setCedula(cedulaField.getText());

        UserName userName = new UserName();
        userName.setUsername(txtUsername.getText());
        userName.setPassword(txtPassword.getText());

        administrador.setUserName(userName);

        return administrador;
    }

    @FXML
    private void handleCancelButtonAction() {
        nombreField.clear();
        cedulaField.clear();


    }

    private boolean validarCampos(String nombre, String cedula
            , String username, String password) {
        return !nombre.isEmpty() && !cedula.isEmpty()
                && !username.isEmpty() && !password.isEmpty();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

