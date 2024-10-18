package calculatorlv3;


public enum OperatorType {
    SUM('+', new AddOperation()),
    SUBTRACT('-', new SubtractOperation()),
    MULTIPLY('*', new MultiplyOperation()),
    DIVIDE('/', new DivideOperation());

    final private char symbol;
    final private Operation operation;

    OperatorType(char symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    /**
     * 연산 기호(symbol)과 해당하는 연산식을 제공한다
     *
     * @param operator : 사칙연산 기호
     * @return : 사칙연산 기호에 해당하는 OperatorType value 를 반환
     * @throws WrongInputException : 입력값이 사칙연산 기호가 아님 -> operator : 잘못된 연산 기호입니다.
     */
    public static OperatorType fromOperator(char operator) throws WrongInputException {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol == operator) {
                return type;
            }
        }
        throw new WrongInputException(Character.toString(operator));
    }

    public double calculate(double number1, double number2) throws WrongInputException {
        return this.operation.apply(number1, number2);
    }
}
