package calculatorlv3;

import static calculatorlv3.OperatorType.SUM;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;
    T number1;
    T number2;

    ArithmeticCalculator(char operator, T number1, T number2){
        this.number1 = number1;
        this.number2 = number2;

        if(operator == SUM.getOperator()){
            operatorType = SUM;
        }else if(operator == OperatorType.SUBTRACT.getOperator()){
            operatorType = OperatorType.SUBTRACT;
        }else if(operator == OperatorType.DIVIDE.getOperator()){
            operatorType = OperatorType.DIVIDE;
        }else if(operator == OperatorType.MULTIPLY.getOperator()){
            operatorType = OperatorType.MULTIPLY;
        }else{
            // TODO: 예외 메서드 작성
            System.out.println("잘못된 연산자입니다.");
            this.operatorType = null;
        }
    }

    public double calculate(){
        Number result = operatorType.calculate(number1.doubleValue(), number2.doubleValue());
        return result.doubleValue();
    }
}
