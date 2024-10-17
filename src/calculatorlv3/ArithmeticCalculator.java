package calculatorlv3;

/*
 Double, Integer 두 타입으로 피연산자를 받습니다.
 OperatorType enum 과 비교하여 연산 방법을 설정합니다.
 calculate() 는 설정한 방법의 연산을 진행하고, 결과를 double 로 반환합니다.
 */

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
        }
    }

    public double calculate() {
        Number result = operatorType.calculate(number1.doubleValue(), number2.doubleValue());
        return result.doubleValue();
    }
}
