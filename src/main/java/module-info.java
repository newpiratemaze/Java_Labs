module com.example.lab2fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab2fx to javafx.fxml;
    exports com.example.lab2fx;
}