package calculatorlv3;

public interface Operation {
    /**
     *
     * @param number1 : 첫번째 피연산자
     * @param number2 : 두번째 피연산자
     * @return : 계산 결과
     * @throws WrongInputException : 나눗셈에서 분모에 0이 들어오면 예외 발생
     */
    double apply(double number1, double number2) throws WrongInputException;
}

class AddOperation implements Operation {
    @Override
    public double apply(double number1, double number2) throws WrongInputException {
        return number1 + number2;
    }
}

class SubtractOperation implements Operation {
    @Override
    public double apply(double number1, double number2) throws WrongInputException {
        return number1 - number2;
    }
}

class MultiplyOperation implements Operation {
    @Override
    public double apply(double number1, double number2) throws WrongInputException {
        return number1 * number2;
    }
}

class DivideOperation implements Operation {
    @Override
    public double apply(double number1, double number2) throws WrongInputException {
        if (number2 == 0) {
            throw new WrongInputException("나눗셈 분모가 0");
        } else {
            return number1 / number2;
        }
    }
}
