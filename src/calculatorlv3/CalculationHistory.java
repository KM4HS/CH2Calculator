package calculatorlv3;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private static class HistoryList {
        double number1;
        double number2;
        char operator;
        double result;

        /**
         * 계산 결과를 저장하는 객체
         *
         * @param number1  : 첫번째 피연산자
         * @param number2  : 두번째 피연산자
         * @param operator : 연산 기호
         * @param result   : 연산 결과
         */
        HistoryList(double number1, double number2, char operator, double result) {
            this.number1 = number1;
            this.number2 = number2;
            this.operator = operator;
            this.result = result;
        }
    }

    private final List<HistoryList> calculationHistories = new ArrayList<>();

    /**
     * @return : {@code calculationHistories}에 값이 없을 경우 {@code true}
     */
    public boolean isHistoriesEmpty() {
        return calculationHistories.isEmpty();
    }

    public void addHistories(double number1, double number2, char operator, double result) {
        calculationHistories.add(new HistoryList(number1, number2, operator, result));
    }

    public void removeFirstHistory() {
        calculationHistories.remove(0);
    }

    public void getCalculationHistoriesAsString() {
        for (HistoryList c : calculationHistories) {
            System.out.println(c.number1 + " " + c.operator + " " + c.number2 + " = " + c.result);
        }
    }

    /**
     * 비교값이 들어오면 해당 값보다 큰 결과만 리스트에서 출력
     *
     * @param num : 비교값
     */
    public void getCalculationHistoriesAsString(double num) {
        List<HistoryList> temp = calculationHistories.stream()
                .filter(ch -> ch.result > num)
                .toList();
        for (HistoryList t : temp) {
            System.out.println(t.number1 + " " + t.operator + " " + t.number2 + " = " + t.result);
        }
    }
}


