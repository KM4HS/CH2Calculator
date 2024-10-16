package calculatorlv3;

public class CalculationHistory {
    double number1;
    double number2;
    char operator;
    double result;

    CalculationHistory(double number1, double number2, char operator, double result){
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
        this.result = result;
    }

    public String getCalculationHistoryAsString(){
        return number1 + " " + operator + " " + number2 + " = " + result;
    }
}
