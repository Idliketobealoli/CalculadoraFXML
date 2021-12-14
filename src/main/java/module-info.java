module lcom.example.calculadorafxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens lcom.example.calculadorafxml to javafx.fxml;
    exports lcom.example.calculadorafxml;
}