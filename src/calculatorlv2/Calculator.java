package calculatorlv2;

import java.util.ArrayList;

public class Calculator {
    private AbstractOperation abstractOperation;
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private final ArrayList<Integer> resultsArr = new ArrayList<Integer>();
    public void addResult(int result){
        resultsArr.add(result);
    }
    public String getResult(){
        return resultsArr.toString();
    }

    public int calculate(int firstNumber, int secondNumber, char operator) {
        switch(operator){
            case '+' -> abstractOperation = new AddOperation();
            case '-' -> abstractOperation = new SubtractOperation();
            case '/' -> abstractOperation = new DivideOperation();
            case '*' -> abstractOperation = new MultiplyOperation();
        }
        return (int) abstractOperation.calculate(firstNumber, secondNumber);
    }


    public void removeResult() {
        /* 구현 */
        resultsArr.remove(0);
    }
}