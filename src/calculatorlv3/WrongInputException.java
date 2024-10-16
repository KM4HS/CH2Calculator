package calculatorlv3;

public class WrongInputException extends Exception{
    public WrongInputException(String wrongOperator){
        super (wrongOperator + " : 잘못된 입력입니다.");
    }
}
