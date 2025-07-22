package org.example.calculator.lv3;

import java.util.*;

public class ArithmeticCalculator {

    private List<Number> results = new ArrayList<>(); // 연산 결과들을 저장하는 리스트

    // 입력 받은 값들을 받고 다시 반환하는 중간다리 역할
    public Optional<Double> calculate(double num1, double num2, char operator) {
        try { // 에러로 인한 중단이 없도록 try catch 문 활용
            Operation operation = Operation.fromSymbol(operator);
            double result = operation.apply(num1, num2);
            results.add(result);
            return Optional.of(result); // 결과값을 main 메서드로 반환
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 던져둔 예외 메시지 출력
            return Optional.empty();
        }
    }

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    public void removeResult(int delNum) {
        if (delNum < 0 || delNum >= results.size()) {
            System.out.println("해당 위치에 값이 존재하지 않습니다.");
            return;
        }
        results.remove(delNum);
        System.out.println("삭제되었습니다.");
        System.out.println("현재 목록: " + results); // 삭제 후 결과 출력
    }

    public double isValid(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + " 숫자를 입력하세요: ");
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) { // 입력값이 숫자가 아닌 경우
                System.out.println("숫자가 아닌 값을 입력하였습니다. 다시 입력해주세요!");
                scanner.next(); // 남아 있는 잘못된 입력값 제거
            }
        }
    }
}
