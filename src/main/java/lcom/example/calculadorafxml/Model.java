package lcom.example.calculadorafxml;

public class Model {
    private static Model instance;
    private Double result = null;
    private String operator = "";
    private String num1 = "";
    private String num2 = "";

    private Model() {
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public Double calculate(Double n1, Double n2, String operator) {
        if (n1 != null && n2 != null && operator != null) {
            switch (operator.charAt(0)) {
                case '+':
                    return n1 + n2;
                case '-':
                    return n1 - n2;
                case '/':
                    return n1 / n2;
                case '*':
                    return n1 * n2;
                case '%':
                    return n1 % n2;
                default:
                    return 0.0;
            }
        } else return null;
    }

    public void reset() {
        num1 = "";
        num2 = "";
        operator = "";
        result = null;
    }

    public void setNum1(String n) {
        this.num1 = n;
    }

    public void setNum2(String n) {
        this.num2 = n;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(Double n1, Double n2, String operator) {
        this.result = calculate(n1, n2, operator);
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public String getResult() {
        return String.valueOf(result);
    }

    public String getOperationSoFar() {
        return getNum1() + getOperator() + getNum2();
    }
}
