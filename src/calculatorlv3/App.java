package calculatorlv3;

import java.util.Scanner;

/*
 계산기 실행을 위한 main 메서드가 있는 클래스입니다.
 String 으로 입력값을 받고, Parser 에서 변환값을 받습니다.
 입력받은 값이 둘 다 정수면 int, 하나라도 실수면 double 로 계산기 클래스에 입력값을 넘깁니다.
 반환받은 결과값이 정수면 정수, 실수면 실수형으로 출력합니다.

 CalculationHistory 클래스를 통해 결과 데이터를 저장합니다.
 또한, 특정 숫자 이상의 결과값을 필터링합니다.
*/

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        CalculationHistory calculationHistory = new CalculationHistory();

        while (true) {
            ArithmeticCalculator calculator;
            double result;
            double num1 = 0;
            double num2 = 0;
            char operator=' ';

            System.out.print("첫 번째 숫자를 입력하세요: ");
            try{
                num1 = parser.parseNumber(sc.nextLine());
            }catch(WrongInputException e){
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
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
                if(operator==OperatorType.DIVIDE.getOperator() && num2==0){
                    System.out.println("나누는 숫자는 0이 될 수 없습니다.");
                    System.out.println();
                    continue;
                }else{
                    calculator = new ArithmeticCalculator<>(operator, num1, num2);
                }
            }
            result = calculator.calculate();
            calculationHistory.addHistories(num1, num2, operator, result);
            if(isInteger && operator!=OperatorType.DIVIDE.getOperator()) {
                System.out.println("결과 : "+(int)result);
            }else {
                System.out.println("결과 : "+result);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (sc.nextLine().equals("exit")) {
                break;
            }

            if (calculationHistory.isHistoriesEmpty()) {
                continue;
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            if (sc.nextLine().equals("remove")) {
                calculationHistory.removeFirstHistory();
                System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다.");
            }

            System.out.print("결과값을 필터링해서 보시겠습니까? (yes 입력 시 필터 적용): ");
            boolean flag = sc.nextLine().equals("yes");
            if(flag){
                System.out.print("기준 숫자를 입력해주세요 : ");
                double num = Double.parseDouble(sc.nextLine());
                System.out.println("지금까지 저장된 " + num + " 이상의 데이터 : ");
                calculationHistory.getCalculationHistoriesAsString(num);

            }else{
                System.out.println("지금까지 저장된 데이터 : ");
                calculationHistory.getCalculationHistoriesAsString();
            }
            System.out.println();
        }

    }
}

