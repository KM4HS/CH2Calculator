package calculatorlv3;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;

    ArithmeticCalculator(char operator){
        if(operator == OperatorType.SUM.getOperator()){
            operatorType = OperatorType.SUM;
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

    public T calculate(double number1, double number2){
        return (T) operatorType.calculate(number1, number2);
    }
}
