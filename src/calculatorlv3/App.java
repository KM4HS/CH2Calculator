package calculatorlv3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        ArrayList<CalculationHistory> calculationHistories = new ArrayList<>();

        while (true) {
            ArithmeticCalculator calculator;
            double result;
            double num1 = 0;
            double num2 = 0;
            char operator=' ';

            System.out.print("첫 번째 숫자를 입력하세요:");
            try{
                num1 = parser.parseNumber(sc.nextLine());
            }catch(WrongInputException e){
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요:");
            try{
                num2 = parser.parseNumber(sc.nextLine());
            }catch(WrongInputException e){
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            try{
                operator = parser.parseOperator(sc.nextLine());
            }catch(WrongInputException e){
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }

            // 정수일 때와 실수일 때 구분하여 출력
            // TODO: 중복되는 코드를 어떻게 나누면 좋을지...
            // 1번 방법 :
            /*try {
                if ((num1 % 1 == 0) && (num2 % 1 == 0)) {
                    ArithmeticCalculator<Integer> calculator = new ArithmeticCalculator<>(operator, (int) num1, (int) num2);
                    result = calculator.calculate();
                    System.out.println("결과 : " + (int) result);
                    calculationHistories.add(new CalculationHistory(num1, num2, operator, result));

                } else {
                    ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(operator, num1, num2);
                    result = calculator.calculate();
                    System.out.println("결과 : " + result);
                    calculationHistories.add(new CalculationHistory(num1, num2, operator, result));
                }
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }*/

            // 2번 방법 :
            boolean isInteger = (num1 % 1 == 0) && (num2 % 1 == 0);

            if(isInteger){
                calculator = new ArithmeticCalculator<>(operator, (int) num1, (int) num2);
            }else{
                calculator = new ArithmeticCalculator<>(operator, num1, num2);
            }
            result = calculator.calculate();
            calculationHistories.add(new CalculationHistory(num1, num2, operator, result));
            if(isInteger) {
                System.out.println("결과 : "+(int)result);
            }else {
                System.out.println("결과 : "+result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) {
                break;
            }

            if (!calculationHistories.isEmpty()) {
                System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if (sc.nextLine().equals("remove")) {
                    calculationHistories.remove(0);
                    System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다.");
                }

                System.out.println("지금까지 저장된 데이터 : ");
                for (CalculationHistory history : calculationHistories) {
                    System.out.println(history.getCalculationHistoryAsString());
                }
            }
            System.out.println();
        }

    }
}

