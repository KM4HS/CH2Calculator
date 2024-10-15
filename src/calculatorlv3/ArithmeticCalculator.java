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

    public T calculate(T number1, T number2){
        Number result = operatorType.calculate(number1.doubleValue(), number2.doubleValue());
        return (T)Double.valueOf(result.doubleValue());
        /*try{
            return (T)Integer.valueOf(result.intValue());
        }catch(Exception e){

        }*/
    }
}

/*class Results{
    private int intResult;
    private double doubleResult;

    public void setIntResult(int intResult) {
        this.intResult = intResult;
    }
    public void setDoubleResult(double doubleResult) {
        this.doubleResult = doubleResult;
    }

    public int getIntResult(){
        return (int)doubleResult + intResult;
    }
    public double getDoubleResult(){
        return doubleResult+intResult;
    }
}*/
