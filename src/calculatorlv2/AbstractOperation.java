package calculatorlv2;

public abstract class AbstractOperation {
    abstract double calculate(int firstNum, int secondNum);
}

class AddOperation extends AbstractOperation{
    @Override
    double calculate(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}

class SubtractOperation extends AbstractOperation{
    @Override
    double calculate(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}

class DivideOperation extends AbstractOperation{
    @Override
    double calculate(int firstNum, int secondNum) {
        return (double) firstNum / secondNum;
    }
}

class MultiplyOperation extends AbstractOperation{
    @Override
    double calculate(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
