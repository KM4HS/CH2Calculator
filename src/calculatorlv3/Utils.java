package calculatorlv3;

enum Commands {
    REMOVE,
    EXIT,
    YES;
}

public class Utils {
    private Utils() {
    }

    /**
     * @param numberInput : 문자열을 입력받음
     * @return : 문자열이 숫자일 경우 {@code double}형을 반환
     * @throws WrongInputException : 문자열이 숫자가 아닌 경우 예외 발생
     */
    public static double parseNumber(String numberInput) throws WrongInputException {
        try {
            return Double.parseDouble(numberInput);
        } catch (Exception e) {
            throw new WrongInputException(numberInput);
        }
    }
}
