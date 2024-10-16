package calculatorlv3;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    double number1;
    double number2;
    char operator;
    double result;

    ArrayList<CalculationHistory> calculationHistories;

    CalculationHistory(){
        this.calculationHistories = new ArrayList<>();
    }
    private CalculationHistory(double number1, double number2, char operator, double result){
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
        this.result = result;
    }

    public boolean isHistoriesEmpty(){
        return calculationHistories.isEmpty();
    }
    public void addHistories(double number1, double number2, char operator, double result){
        calculationHistories.add(new CalculationHistory(number1, number2, operator, result));
    }
    public void removeFirstHistory(){
        calculationHistories.remove(0);
    }

    public void getCalculationHistoriesAsString(){
        for(CalculationHistory c : calculationHistories){
            System.out.println(c.number1 + " " + c.operator + " " + c.number2 + " = " + c.result);
        }
    }
    public void getCalculationHistoriesAsString(double num){
        List<CalculationHistory> temp = calculationHistories.stream()
                .filter(ch -> ch.getResult() > num)
                .toList();
        for(CalculationHistory t : temp){
            System.out.println(t.number1 + " " + t.operator + " " + t.number2 + " = " + t.result);
        }
    }

    private double getResult(){
        return this.result;
    }
}
