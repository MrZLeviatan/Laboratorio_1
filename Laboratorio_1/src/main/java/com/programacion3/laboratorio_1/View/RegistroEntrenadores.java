package com.programacion3.laboratorio_1.View;

import com.programacion3.laboratorio_1.Controller.RegistroController;
import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Model.Deporte;
import com.programacion3.laboratorio_1.Model.Entrenador;
import com.programacion3.laboratorio_1.Model.UserName;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistroEntrenadores {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField cedulaField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<Deporte> deporteComboBox;
    @FXML
    private TableView<Entrenador> tablaEntrenadores;
    @FXML
    private TableColumn<Entrenador, String> colNombre;
    @FXML
    private TableColumn<Entrenador, String> colCedula;
    @FXML
    private TableColumn<Entrenador, String> colUsername;
    @FXML
    private TableColumn<Entrenador, String> colDeporte;

    RegistroController registroController;

    private ObservableList<Entrenador> listaEntrenadores = FXCollections.observableArrayList();



    @FXML
    public void initialize() {

        registroController = new RegistroController();

        deporteComboBox.getItems().addAll(registroController.obtenerDeportes());
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colUsername.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName().getUsername()));
        colDeporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeporte().getNombre()));

        tablaEntrenadores.setItems(listaEntrenadores);


        registroController = new RegistroController();
    }


private Entrenador crearEntrenador(){
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(nombreField.getText());
        entrenador.setCedula(cedulaField.getText());

        UserName userName = new UserName();
        userName.setUsername(usernameField.getText());
        userName.setPassword(passwordField.getText());

        entrenador.setUserName(userName);

        String deporteNombre = deporteComboBox.getValue().getNombre();
        Deporte deporte = registroController.hallarDeporte(deporteNombre);

        entrenador.setDeporte(deporte);

        return entrenador;
}



    @FXML
    void registrarEntrenador(ActionEvent event) throws PersonaException {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        String deporteNombre = deporteComboBox.getValue().getNombre();
        Deporte deporte = registroController.hallarDeporte(deporteNombre);

        if (!nombre.isEmpty() && !cedula.isEmpty() && !username.isEmpty() && !password.isEmpty() && deporte != null) {
            if (registroController.registroEntrenador(crearEntrenador())){
                mostrarAlerta("Registro Exitoso", "El Entrenador " + nombre + " ha sido registrado");
                limpiarCampos();
            }else{
                mostrarAlerta("Registro Fallido", "Ocurrio un error en el registro");
            }
        } else {
            mostrarAlerta("Error", "Por favor, complete todos los campos.");
        }
    }

    @FXML
    private void actualizarEntrenador() {
        // Implementa la lógica para actualizar un entrenador
    }

    @FXML
    private void eliminarEntrenador() {
        // Implementa la lógica para eliminar un entrenador
    }

    private void limpiarCampos() {
        nombreField.clear();
        cedulaField.clear();
        usernameField.clear();
        passwordField.clear();
        deporteComboBox.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

