package calculatorlv3;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;
    char operator;
    T number1;
    T number2;

    ArithmeticCalculator(char operator, T number1, T number2){
        this.operator = operator;
        this.number1 = number1;
        this.number2 = number2;

        if(operator == OperatorType.SUM.getOperator()){
            operatorType = OperatorType.SUM;
        }else if(operator == OperatorType.SUBTRACT.getOperator()){
            operatorType = OperatorType.SUBTRACT;
        }else if(operator == OperatorType.DIVIDE.getOperator()){
            operatorType = OperatorType.DIVIDE;
        }else if(operator == OperatorType.MULTIPLY.getOperator()){
            operatorType = OperatorType.MULTIPLY;
        }else{
            this.operatorType = null;
        }
    }

    // TODO: 연산자가 나눗셈일 때 예외 처리
    //     - 정수형 2개 입력이어도 실수로 출력
    //     - 분모가 0일 때 예외 던지기
    public double calculate() {
        Number result = operatorType.calculate(number1.doubleValue(), number2.doubleValue());
        return result.doubleValue();
    }
}
