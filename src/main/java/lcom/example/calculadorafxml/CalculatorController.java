package lcom.example.calculadorafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculatorController {
    @FXML private Button Button0;
    @FXML private Button Button1;
    @FXML private Button Button2;
    @FXML private Button Button3;
    @FXML private Button Button4;
    @FXML private Button Button5;
    @FXML private Button Button6;
    @FXML private Button Button7;
    @FXML private Button Button8;
    @FXML private Button Button9;
    @FXML private Button ButtonAddition;
    @FXML private Button ButtonBackspace;
    @FXML private Button ButtonClear;
    @FXML private Button ButtonEquals;
    @FXML private Button ButtonMultiplication;
    @FXML private Button ButtonPoint;
    @FXML private Button ButtonSubtraction;
    @FXML private AnchorPane anchorPane;
    @FXML private Button buttonDivide;
    @FXML private Button buttonModule;
    @FXML private GridPane gridPane;
    @FXML private Label pantallaAbajo;
    @FXML private Label pantallaArriba;
    @FXML private VBox vBox;
    Model model = Model.getInstance();

    @FXML public void manageNumberPressed(ActionEvent ev) {
        String e = ((Button) ev.getSource()).getText();
        if (model.getOperator().equalsIgnoreCase("")) {
            if (!model.getNum1().equalsIgnoreCase("")) {
                if (e.equalsIgnoreCase(".") && model.getNum1().contains(".")) {
                } else {
                    model.setNum1(model.getNum1().concat(e));
                }
            } else if (!e.equalsIgnoreCase(".")) {
                model.setNum1(e);
            } else model.setNum1("0.");
        } else {
            if (!model.getNum2().equalsIgnoreCase("")) {
                if (e.equalsIgnoreCase(".") && model.getNum2().contains(".")) {
                } else {
                    model.setNum2(model.getNum2().concat(e));
                }
            } else if (!e.equalsIgnoreCase(".")) {
                model.setNum2(e);
            } else model.setNum2("0.");
        }
        pantallaAbajo.setText(model.getOperationSoFar());
    }

    @FXML public void manageOperation(ActionEvent ev) {
        String e = ((Button) ev.getSource()).getText();
        if (model.getNum1().equalsIgnoreCase("")) {
            model.setNum1("0");
        }
        model.setOperator(e);
        pantallaAbajo.setText(model.getOperationSoFar());
    }

    @FXML public void manageBackspace() {
        if (!model.getNum2().equalsIgnoreCase("")) {
            if (model.getNum2().length() == 1) {
                model.setNum2("");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < (model.getNum2().length() - 1); i++) {
                    sb.append(model.getNum2().charAt(i));
                }
                model.setNum2(sb.toString());
            }
        } else if (!model.getOperator().equalsIgnoreCase("")) {
            model.setOperator("");
        } else if (!model.getNum1().equalsIgnoreCase("")) {
            if (model.getNum1().length() == 1) {
                model.setNum1("");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < (model.getNum1().length() - 1); i++) {
                    sb.append(model.getNum1().charAt(i));
                }
                model.setNum1(sb.toString());
            }
        }
        pantallaAbajo.setText(model.getOperationSoFar());
    }

    @FXML public void manageClear() {
        model.reset();
        pantallaAbajo.setText(model.getOperationSoFar());
        pantallaArriba.setText(model.getOperationSoFar());
    }

    @FXML public void manageEqual() {
        if (!model.getNum2().equalsIgnoreCase("")) {
            model.setResult(Double.parseDouble(model.getNum1()),
                    Double.parseDouble(model.getNum2()),
                    model.getOperator());
        } else if (!model.getNum1().equalsIgnoreCase("")) {
            model.setResult(Double.parseDouble(model.getNum1()), 0.0, "+");
        } else model.setResult(0.0, 0.0, "+");
        pantallaAbajo.setText(model.getResult());
        pantallaArriba.setText(model.getOperationSoFar());
    }
}