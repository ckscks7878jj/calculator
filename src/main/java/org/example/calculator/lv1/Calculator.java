package org.example.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        char answer;
        String answer = ""; // 초기값 설정 없이 중간에 수동으로 멈춰버리면 에러가 뜨는 걸 확인
        do {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.println("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();
            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            int result = 0;

//        if (operator == '+') {
//            result = num1 + num2;
//        } else if (operator == '-') {
//            result = num1 - num2;
//        } else if (operator == '*') {
//            result = num1 * num2;
//        } else if (operator == '/') {
//            if (num2 == 0) {
//                System.out.println("0으로 나눌 수 없습니다.");
//                return; // 결과값으로 안가고 멈춤
//            } else {
//                result = num1 / num2;
//            }
//        } else {
//            System.out.println("잘못된 연산 기호입니다.");
//        }
//        System.out.println("결과: " + result);

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.\n");
                        continue; // result 출력 스킵
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.\n");
                    continue;
            }
            System.out.println("결과: " + result);

            System.out.println("\n더 계산하려면 아무거나 입력하세요. (exit 입력 시 종료)");
            answer = scanner.next();

//            System.out.println("다시 계산하시겠습니까? (Y/N): ");
//            answer = scanner.next().charAt(0);
//        } while (answer == 'Y' || answer == 'y');
        } while (!answer.equalsIgnoreCase("exit")); // 대소문자 무시
    }
}
