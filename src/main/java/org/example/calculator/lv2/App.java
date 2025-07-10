package org.example.calculator.lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String answer = ""; // do-while 문 안에 선언 시 while에서 변수 인식 못함
        do {
            System.out.print("첫 번째 숫자를 입력하세요: "); // 입력 값이 정수가 아닐 경우 경고 메시지 출력되게
            int num1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            int result = calculator.calculate(num1, num2, operator);
            System.out.println("결과: " + result);
            System.out.println("결과 목록: " + calculator.getResults());

            System.out.print("첫 결과 값을 삭제하시겠습니까? 삭제하려면 Y를 입력하세요.: "); // 원하는 값을 삭제할 수 있게
            String delNumber = scanner.next();
            if (delNumber.equalsIgnoreCase("Y")) {
                calculator.removeResult();
            }
            System.out.println("결과 목록: " + calculator.getResults());

            System.out.println("더 계산하려면 아무거나 입력하세요. exit 입력 시 종료됩니다.");
            answer = scanner.next();

        } while (!answer.equalsIgnoreCase("exit")); // 대소문자 무시

    }
}
