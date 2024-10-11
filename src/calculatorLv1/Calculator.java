package calculatorLv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int firstNum = Integer.parseInt(sc.nextLine());
            System.out.print("두 번째 숫자를 입력하세요 : ");
            int secondNum = Integer.parseInt(sc.nextLine());
            System.out.print("사칙연산 기호를 입력하세요 : ");
            char operator = sc.nextLine().charAt(0);

            switch (operator) {
                case '+':
                    System.out.println("결과 = "+ (firstNum + secondNum));
                    break;
                case '-':
                    System.out.println("결과 = "+ (firstNum - secondNum));
                    break;
                case '*':
                    System.out.println("결과 = "+ (firstNum * secondNum));
                    break;
                case '/':
                    if(secondNum == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); break;
                    }
                    System.out.println("결과 = "+ (firstNum / secondNum));
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.");
                    break;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력시 종료) : ");
            if(sc.nextLine().equals("exit")) break;
        }
    }
}