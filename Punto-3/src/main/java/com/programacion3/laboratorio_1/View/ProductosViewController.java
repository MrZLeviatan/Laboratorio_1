package com.programacion3.laboratorio_1.View;

import com.programacion3.laboratorio_1.Model.Enum.TipoCategoria;
import com.programacion3.laboratorio_1.Model.Producto;
import com.programacion3.laboratorio_1.Model.Punto3;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ProductosViewController {

    @FXML
    private ComboBox<TipoCategoria> cbxCategoria;

    @FXML
    private Label lbMensajeTotal;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableView<Producto> tblProductosSelec;

    @FXML
    private TableColumn<Producto, TipoCategoria> tcCategoria;

    @FXML
    private TableColumn<Producto, TipoCategoria> tcCategoriaPS;

    @FXML
    private TableColumn<Producto, String> tcCodigo;

    @FXML
    private TableColumn<Producto, String> tcCodigoPS;

    @FXML
    private TableColumn<Producto, String> tcDescripcion;

    @FXML
    private TableColumn<Producto, String> tcDescripcionPS;

    @FXML
    private TableColumn<Producto, String> tcNombre;

    @FXML
    private TableColumn<Producto, String> tcNombrePS;

    @FXML
    private TableColumn<Producto, Double> tcPrecio;

    @FXML
    private TableColumn<Producto, Double> tcPrecioPS;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfDescripcion;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPrecio;

    private Punto3 punto3 = new Punto3();

    // Lista de productos seleccionados
    private ArrayList<Producto> productosSeleccionados = new ArrayList<>();


    // Lista observable para mostrar productos en la tabla
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductosSeleccionados = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        // Configura las columnas para que muestren los datos
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tcCategoria.setCellValueFactory(new PropertyValueFactory<>("tipoCategoria"));

        tcCodigoPS.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcDescripcionPS.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcNombrePS.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPrecioPS.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tcCategoriaPS.setCellValueFactory(new PropertyValueFactory<>("tipoCategoria"));

        // Inicializar el ComboBox de categorías
        cbxCategoria.setItems(FXCollections.observableArrayList(TipoCategoria.values()));
        // Inicializar tablas con listas vacías
        tblProductos.setItems(listaProductos);
        tblProductosSelec.setItems(listaProductosSeleccionados);


        // Agregar un listener para detectar cuando se selecciona un producto en la tabla
        tblProductos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producto>() {
            @Override
            public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
                if (newValue != null) {
                    // Llenar los campos de texto y ComboBox con los valores del producto seleccionado
                    tfCodigo.setText(newValue.getCodigo());
                    tfCodigo.setEditable(false);
                    tfDescripcion.setText(newValue.getDescripcion());
                    tfNombre.setText(newValue.getNombre());
                    tfPrecio.setText(String.valueOf(newValue.getPrecio()));
                    cbxCategoria.setValue(newValue.getTipoCategoria());
                }
            }
        });
    }


    @FXML
    void agregar(ActionEvent event) {
        if (verificarCampos()){
            Producto producto = crearProducto();
            punto3.addProducto(producto);
            listaProductos.add(producto);
            mostrarMensaje("Notificacion","Se agrega el " +
                            "producto exitosamente"
                    ,"Se agrego el producto "+producto.getNombre(),Alert.AlertType.INFORMATION);
            limpiar();
        }else{
            mostrarMensaje("Advertencia","Llene todos los campos"
                    ,"Llene todos los campor",Alert.AlertType.ERROR);
        }
    }

    // Metodo nato para crear el producto perfectamente.
    private Producto crearProducto(){
        Producto producto = new Producto();
        producto.setCodigo(tfCodigo.getText());
        producto.setNombre(tfNombre.getText());
        producto.setDescripcion(tfDescripcion.getText());
        producto.setPrecio(Double.parseDouble(tfPrecio.getText()));
        producto.setTipoCategoria(cbxCategoria.getValue());

        return producto;

    }

    // Metodo nato para verificar los campos que no esten vacios.
    private boolean verificarCampos(){
        return !tfCodigo.getText().isEmpty() && !tfNombre.getText().isEmpty() &&
                !tfDescripcion.getText().isEmpty() && !tfPrecio.getText().isEmpty()
                && cbxCategoria.getValue() != null;
    }

    @FXML
    void eliminar(ActionEvent event) {
        Producto productoSeleccionado = tblProductos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            punto3.removeProducto(productoSeleccionado);
            listaProductos.remove(productoSeleccionado);
            mostrarMensaje("Notificacion","Se elimina el producto exitosamente"
                    ,"Se elimino el producto "+productoSeleccionado.getNombre(),Alert.AlertType.INFORMATION);
            limpiar();
        }else{
            mostrarMensaje("Advertencia","Llene todos los campos"
                    ,"Llene todos los campor",Alert.AlertType.ERROR);
        }
    }

    @FXML
    void actualizar(ActionEvent event) {
        Producto productoSeleccionado = tblProductos.getSelectionModel().getSelectedItem();
        Producto productoActualizado = crearProducto();
        if (productoSeleccionado != null) {
            if (verificarCampos()) {
                punto3.actualizarProducto(productoSeleccionado.getCodigo(), productoActualizado);
                listaProductos.set(listaProductos.indexOf(productoSeleccionado), productoActualizado);
                mostrarMensaje("Notificacion","Se actualizo el producto exitosamente"
                        ,"Se actualizo el producto "+productoSeleccionado.getNombre(),Alert.AlertType.INFORMATION);
                limpiar();
            }else{
                mostrarMensaje("Advertencia","Llene todos los campos"
                        ,"Llene todos los campor",Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Advertencia","Seleccione un producto"
                    ,"Seleccione un producto de la tabla",Alert.AlertType.ERROR);
        }
    }


    @FXML
    void seleccionProducto(ActionEvent event) {
        // Obtener el producto seleccionado de la tabla de productos
        Producto productoSeleccionado = tblProductos.getSelectionModel().getSelectedItem();

        if (productoSeleccionado != null && !listaProductosSeleccionados.contains(productoSeleccionado)) {
            listaProductosSeleccionados.add(productoSeleccionado);
        }
    }

    @FXML
    void calcularPrecio(ActionEvent event) {
// Calcular el total usando la función recursiva con descuento
        double totalConDescuento = Punto3.calcularTotalConDescuento(new ArrayList<>(listaProductosSeleccionados));

        // Mostrar el total en el Label
        lbMensajeTotal.setText("Total con descuento: $" + totalConDescuento);
    }


    @FXML
    void deSeleccionarProducto(ActionEvent event) {

        Producto productoSeleccionado = tblProductosSelec.getSelectionModel().getSelectedItem();

        if (productoSeleccionado != null) {
            listaProductosSeleccionados.remove(productoSeleccionado);
        }
    }


    @FXML
    void limpiar(ActionEvent event) {
        limpiar();
    }

    // Metodo para mostrar mensaje visual
    private void mostrarMensaje(String titulo, String mensaje,
                                String contenido, Alert.AlertType tipo) {

        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void limpiar(){
        tfCodigo.clear();
        tfNombre.clear();
        tfDescripcion.clear();
        tfPrecio.clear();
        cbxCategoria.getSelectionModel().clearSelection();
    }



}

