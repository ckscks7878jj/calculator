package org.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        String answer = "";
        do {

            // 첫 번째 숫자
            double num1 = calculator.isValid(scanner, "첫 번째");

            // 두 번째 숫자
            double num2 = calculator.isValid(scanner, "두 번째");

            // 연산자 입력
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            // 계산 및 기록
            double result = calculator.calculate(num1, num2, operator);
            if (result == (int) result) {
                System.out.println("결과: " + (int) result);
            } else {
                System.out.println("결과: " + result);
            }
            System.out.println("결과 목록: " + calculator.getResults());

            // 입력값 보다 큰 결과값들 출력 (Stream 활용)
            List<Double> filtered = calculator.getResults().stream()
                    .map(Number::doubleValue) // Number → double로 바꿔준다.
                    .filter(num -> num > Math.max(num1, num2))
                    .toList();
            System.out.println("입력값 보다 큰 결과값들만 출력됩니다.: " + filtered);

            // 연산 결과 삭제 기능
            System.out.print("결과 목록에서 값을 삭제하시겠습니까? (Y/N): ");
            String delete = scanner.next();
            if (delete.equalsIgnoreCase("Y")) {
                System.out.print("삭제하고 결과의 위치를 입력해주세요.(0부터 시작합니다.): ");
                int delNum = scanner.nextInt();
                calculator.removeResult(delNum);
            }
            System.out.println("삭제되었습니다. 현재 목록: " + calculator.getResults()); // 삭제 후 결과 출력

            // 결과 목록 초기화 기능
            System.out.print("결과 목록을 초기화 하시겠습니까? (Y/N): ");
            String reset = scanner.next();
            if (reset.equalsIgnoreCase("Y")) {
                List<Number> newResults = new ArrayList<>();
                calculator.setResults(newResults);
                System.out.println("목록이 초기화 되었습니다.");
            }

            // 추가 계산 유무
            System.out.println("더 계산하려면 아무거나 입력하세요. exit 입력 시 종료됩니다.");
            answer = scanner.next();
        } while (!answer.equalsIgnoreCase("exit"));
    }
}
