package calculatorlv3;

/*
 사칙연산 타입과 연산 클래스를 저장합니다.
 calculate(double, double)는 Number 타입의 결과를 반환합니다.
*/

public enum OperatorType{
    SUM('+', new AddOperation()),
    SUBTRACT('-', new SubtractOperation()),
    MULTIPLY('*', new MultiplyOperation()),
    DIVIDE('/', new DivideOperation());

    final private char operator;
    final private Operation operation;

    OperatorType(char operator, Operation operation){
        this.operator = operator;
        this.operation = operation;
    }

    public char getOperator(){
        return this.operator;
    }
    public Number calculate(double number1, double number2){
        return this.operation.apply(number1, number2);
    }
}
