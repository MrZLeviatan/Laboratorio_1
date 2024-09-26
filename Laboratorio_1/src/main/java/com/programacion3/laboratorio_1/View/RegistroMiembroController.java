package com.programacion3.laboratorio_1.View;

import com.programacion3.laboratorio_1.Controller.RegistroController;
import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Model.Enum.TipoMiembro;
import com.programacion3.laboratorio_1.Model.Miembros;
import com.programacion3.laboratorio_1.Model.UserName;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RegistroMiembroController {

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
    @FXML
    private ComboBox<String> languageComboBox;  // ComboBox para seleccionar el idioma
    @FXML
    private Label nombreLabel, cedulaLabel, correoLabel, tipoMiembroLabel, usernameLabel, passwordLabel;
    @FXML
    private Button registrarButton, cancelarButton;

    private Properties properties;  // Para manejar las cadenas de texto en diferentes idiomas
    private RegistroController registroController;

    @FXML
    public void initialize() {
        // Agregar opciones al ComboBox del tipo de miembro
        tipoMiembroComboBox.getItems().addAll(TipoMiembro.Juvenil, TipoMiembro.Adulto);
        tipoMiembroComboBox.setPromptText("Seleccionar");

        // Inicializar RegistroController
        registroController = new RegistroController();

        // Agregar opciones al ComboBox de idiomas
        languageComboBox.getItems().addAll("Español", "English");

        // Cargar el idioma por defecto (Español)
        loadLanguage("es");

        // Listener para detectar cuando el usuario cambia de idioma
        languageComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if ("English".equals(newValue)) {
                loadLanguage("en");
            } else {
                loadLanguage("es");
            }
        });
    }

    @FXML
    public void loadLanguage(String language) {
        properties = new Properties();
        String filePath;

        if (language.equals("es")) {
            filePath = "src/main/resources/Utils/Espanol.properties";
        } else {
            filePath = "src/main/resources/Utils/Ingles.properties";
        }

        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);

            // Asignar textos a los campos de entrada
            nombreField.setPromptText(properties.getProperty("nombre"));
            cedulaField.setPromptText(properties.getProperty("cedula"));
            correoField.setPromptText(properties.getProperty("correo"));
            txtUsername.setPromptText(properties.getProperty("username"));
            txtPassword.setPromptText(properties.getProperty("password"));

            // Asignar textos a las etiquetas
            nombreLabel.setText(properties.getProperty("nombre"));
            cedulaLabel.setText(properties.getProperty("cedula"));
            correoLabel.setText(properties.getProperty("correo"));
            tipoMiembroLabel.setText(properties.getProperty("tipo_miembro"));
            usernameLabel.setText(properties.getProperty("username"));
            passwordLabel.setText(properties.getProperty("password"));

            // Actualizar los textos de los botones
            registrarButton.setText(properties.getProperty("registrar"));
            cancelarButton.setText(properties.getProperty("cancelar"));
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    @FXML
    private void handleRegistrarButtonAction() throws PersonaException {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String correo = correoField.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (validarCampos(nombre, cedula, correo, tipoMiembroComboBox, username, password)) {
            if (registroController.registrarMiembro(crearMiembro())) {
                mostrarAlerta(properties.getProperty("registrar"), properties.getProperty("nombre") + " " + nombre + " ha sido registrado");
            } else {
                mostrarAlerta(properties.getProperty("registrar"), "Ocurrió un error en el registro");
                handleCancelButtonAction();
            }
        } else {
            mostrarAlerta(properties.getProperty("registrar"), "Por favor, rellena todos los campos correctamente.");
        }
    }

    public Miembros crearMiembro() {
        Miembros miembros = new Miembros();
        miembros.setNombre(nombreField.getText());
        miembros.setCedula(cedulaField.getText());
        miembros.setCorreo(correoField.getText());
        miembros.setTipoMiembro(tipoMiembroComboBox.getValue());

        UserName userName = new UserName();
        userName.setUsername(txtUsername.getText());
        userName.setPassword(txtPassword.getText());

        miembros.setUserName(userName);

        return miembros;
    }

    @FXML
    private void handleCancelButtonAction() {
        nombreField.clear();
        cedulaField.clear();
        correoField.clear();
        txtUsername.clear();
        txtPassword.clear();
        tipoMiembroComboBox.getSelectionModel().clearSelection(); // Limpiar selección de tipo de miembro
    }

    private boolean validarCampos(String nombre, String cedula, String correo, ComboBox<TipoMiembro> tipoMiembroComboBox, String username, String password) {
        return !nombre.isEmpty() && !cedula.isEmpty() && !correo.isEmpty() && tipoMiembroComboBox.getValue() != null
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


