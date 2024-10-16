package calculatorlv3;

public class WrongOperatorException extends Exception{
    public WrongOperatorException(String wrongOperator){
        super (wrongOperator + " : 잘못된 입력입니다.");
    }
}
