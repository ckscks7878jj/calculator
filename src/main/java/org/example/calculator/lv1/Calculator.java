package org.example.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        char answer; // "Y/N" 을 위해 썼던 단일 문자용
        String answer = ""; // "exit" 다중 문자
        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            if (num1 < 0) { // 양의 정수(0 포함)을 놓쳐서 추가
                System.out.println("0를 포함한 양의 정수만 입력이 가능합니다.");
                continue;
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();
            if (num2 < 0) {
                System.out.println("0를 포함한 양의 정수만 입력이 가능합니다.");
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
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
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue; // result 출력 스킵
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.");
                    continue;
            }
            System.out.println("결과: " + result);

            System.out.println("더 계산하려면 아무거나 입력하세요. (exit 입력 시 종료)");
            answer = scanner.next();

//            System.out.println("다시 계산하시겠습니까? (Y/N): ");
//            answer = scanner.next().charAt(0);
//        } while (answer == 'Y' || answer == 'y');
        } while (!answer.equalsIgnoreCase("exit")); // 대소문자 무시
    }
}
