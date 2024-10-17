package calculatorlv3;

public interface Operation {
    double apply(double number1, double number2);
}

class AddOperation implements Operation{
    @Override
    public double apply(double number1, double number2) {
        return number1 + number2;
    }
}

class SubtractOperation implements Operation{
    @Override
    public double apply(double number1, double number2) {
        return number1 - number2;
    }
}

class MultiplyOperation implements Operation{
    @Override
    public double apply(double number1, double number2) {
        return number1 * number2;
    }
}

class DivideOperation implements Operation {
    @Override
    public double apply(double number1, double number2) {
        return number1 / number2;
    }
}
