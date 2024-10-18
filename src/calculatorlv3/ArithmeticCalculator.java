package calculatorlv3;

public class ArithmeticCalculator<T extends Number> {
    private OperatorType operatorType;
    private final T number1;
    private final T number2;

    /**
     * 연산 기호와 피연산자를 받는 생성자
     * {@link OperatorType}의 fromOperator()로 기호에 따른 연산
     *
     * @param operator : 사칙연산 기호
     * @param number1  : 첫번째 피연산자
     * @param number2  : 두번째 피연산자
     */
    ArithmeticCalculator(char operator, T number1, T number2) throws WrongInputException {
        // this.operator = operator;
        this.number1 = number1;
        this.number2 = number2;

        operatorType = OperatorType.fromOperator(operator);
    }

    /**
     * @return : {@link OperatorType}에서의 연산 결과를 리턴
     */
    public double calculate() throws WrongInputException {
        return operatorType.calculate(number1.doubleValue(), number2.doubleValue());
    }
}
