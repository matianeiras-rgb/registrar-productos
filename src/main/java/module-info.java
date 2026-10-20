module com.example.registrarproductos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.registrarproductos to javafx.fxml;
    exports com.example.registrarproductos;
}