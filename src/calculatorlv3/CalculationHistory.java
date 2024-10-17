package calculatorlv3;

import java.util.ArrayList;
import java.util.List;

/*
 결과 데이터 관리를 위한 클래스입니다.
 ArrayList 에 연산에 사용된 숫자, 연산자, 결과를 저장합니다.
 메서드를 통해 외부에서 간접적으로 결과 데이터의 삭제, 추가, 조회가 가능합니다.
 String 형식으로 결과 데이터를 출력합니다.
 출력 메서드에 인자를 받으면 해당 숫자보다 큰 값으로 필터링하여 데이터를 출력합니다.
*/

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
