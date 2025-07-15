package org.example.calculator.lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArithmeticCalculator {

    private List<Number> results = new ArrayList<>(); // 연산 결과들을 저장하는 리스트

    // 입력 받은 값들을 받고 다시 반환하는 중간다리 역할
    public double calculate(double num1, double num2, char operator) {
        try { // 에러로 인한 중단이 없도록 try catch 문 활용
            Operation operation = Operation.fromSymbol(operator);
            double result = operation.apply(num1, num2);
            if (result == (int) result) {
                results.add((int) result); // 결과값이 정수이면 정수로 리스트에 담음
            } else {
                results.add(result); // 계산된 결과값을 실수로 리스트에 담음
            }
            return result; // 결과값을 main 메서드로 반환
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // 던져둔 예외 메시지 출력
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    public void removeResult(int delNum) { // 목록의 첫 번째 값을 삭제
        results.remove(results.get(delNum));
    }

    public double isValid(Scanner scanner, String label) { // 입력값이 양의 정수인지 확인 후 값 반환
        while (true) {
            System.out.print(label + " 숫자를 입력하세요: ");
            try {
                double num = scanner.nextDouble(); // 숫자 입력 받기
                if (num < 0) { // 음수인 경우
                    System.out.println("0를 포함한 양의 정수만 입력이 가능합니다.");
                    continue; // 다시 입력 받기
                }
                return num; // 문제없을 시 값 반환!
            } catch (InputMismatchException e) { // 입력값이 숫자가 아닌 경우
                System.out.println("숫자가 아닌 값을 입력하였습니다. 다시 입력해주세요!");
                scanner.next(); // 남아 있는 잘못된 입력값 제거
            }
        }
    }
}
