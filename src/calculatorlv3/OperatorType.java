package calculatorlv3;

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
