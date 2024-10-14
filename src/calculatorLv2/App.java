package calculatorLv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        while(true){
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            /* 위 요구사항에 맞게 소스 코드 수정 */
            int result = calculator.calculate(num1, num2, operator);
            System.out.println("계산 결과 : " + result);
            calculator.addResult(result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")) break;
            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")) {
                calculator.removeResult();
                System.out.println("삭제되었습니다.");
                System.out.println("현재 저장된 데이터는 "+calculator.getResult()+" 입니다.");
            }
            /* 반복문 종료 */
        }

    }
}
