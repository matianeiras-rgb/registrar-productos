package com.example.registrarproductos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoController {

    @FXML
    private TableView<Producto> tablaProductos;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colCategoria;
    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtPrecio;

    private ObservableList<Producto> listaProductos;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        listaProductos = FXCollections.observableArrayList(
                new Producto("Teclado", "Periféricos", 15000),
                new Producto("Mouse", "Periféricos", 8000),
                new Producto("Monitor", "Pantallas", 95000)
        );

        tablaProductos.setItems(listaProductos);
    }

    @FXML
    private void agregarProducto() {
        String nombre = txtNombre.getText();
        String categoria = txtCategoria.getText();
        String precioTexto = txtPrecio.getText();

        if (!nombre.isEmpty() && !categoria.isEmpty() && !precioTexto.isEmpty()) {
            try {
                double precio = Double.parseDouble(precioTexto);
                Producto nuevoProducto = new Producto(nombre, categoria, precio);
                listaProductos.add(nuevoProducto);

                txtNombre.clear();
                txtCategoria.clear();
                txtPrecio.clear();
            } catch (NumberFormatException e) {
                System.out.println("Error: El precio debe ser un número válido.");
            }
        }
    }
}