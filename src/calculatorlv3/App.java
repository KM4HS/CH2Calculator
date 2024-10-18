package calculatorlv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculationHistory calculationHistory = new CalculationHistory();
        boolean isCalculatorEnded = false;

        do {
            ArithmeticCalculator calculator;
            double result;
            double num1;
            double num2;
            char operator;

            System.out.println("-------------------------");
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Utils.parseNumber(sc.nextLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Utils.parseNumber(sc.nextLine());
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.nextLine().toCharArray()[0];

                boolean isInteger = (num1 % 1 == 0) && (num2 % 1 == 0);

                if (isInteger) {
                    calculator = new ArithmeticCalculator<>(operator, (int) num1, (int) num2);
                } else {
                    calculator = new ArithmeticCalculator<>(operator, num1, num2);
                }
                result = calculator.calculate();

                calculationHistory.addHistories(num1, num2, operator, result);
                if (isInteger && (OperatorType.fromOperator(operator) == OperatorType.DIVIDE)) {
                    System.out.println("결과 : " + (int) result);
                } else {
                    System.out.println("결과 : " + result);
                }
            } catch (WrongInputException e) {
                System.out.println(e.getMessage() + "\n");
                continue;
            }

            if (calculationHistory.isHistoriesEmpty()) {
                continue;
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            if (Commands.REMOVE.name().equals(sc.nextLine().toUpperCase())) {
                calculationHistory.removeFirstHistory();
                System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다.");
            }

            System.out.print("결과값을 필터링해서 보시겠습니까? (yes 입력 시 필터 적용): ");
            if (Commands.YES.name().equals(sc.nextLine().toUpperCase())) {
                System.out.print("기준 숫자를 입력해주세요 : ");
                double num = Double.parseDouble(sc.nextLine());
                System.out.println("지금까지 저장된 " + num + " 이상의 데이터 : ");
                calculationHistory.getCalculationHistoriesAsString(num);
            } else {
                System.out.println("지금까지 저장된 데이터 : ");
                calculationHistory.getCalculationHistoriesAsString();
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            isCalculatorEnded = (Commands.EXIT.name().equals(sc.nextLine().toUpperCase()));
        } while (!isCalculatorEnded);
    }
}

