package calculatorlv3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CalculationHistory> calculationHistories = new ArrayList<>();

        while(true){
            double result = 0;

            System.out.print("첫 번째 숫자를 입력하세요:");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요:");
            double num2 = sc.nextDouble();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            // 정수일 때와 실수일 때 구분하여 출력
            if((num1%1==0)&&(num2%1==0)){
                ArithmeticCalculator<Integer> calculator = new ArithmeticCalculator<>(operator, (int)num1, (int)num2);
                result = calculator.calculate();
                System.out.println("결과 : "+(int)result);
            }else{
                ArithmeticCalculator<Double>calculator = new ArithmeticCalculator<>(operator, num1, num2);
                result = calculator.calculate();
                System.out.println("결과 : "+result);
            }

            // 결과와 식 저장
            calculationHistories.add(new CalculationHistory(num1, num2, operator, result));

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")) break;
            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")){
                calculationHistories.remove(0);
                System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다.");
            }

            System.out.println("지금까지 저장된 데이터 : ");
            for(CalculationHistory history : calculationHistories){
                System.out.println(history.getCalculationHistoryAsString());
            }
            System.out.println();
        }

    }
}
