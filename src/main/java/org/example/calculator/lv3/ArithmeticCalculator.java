package org.example.calculator.lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArithmeticCalculator { // 제네릭 활용 필요

    private List<Integer> results = new ArrayList<>(); // 연산 결과들을 저장하는 리스트

    // 입력 받은 값들을 받고 다시 반환하는 중간다리 역할
    public int calculate(int num1, int num2, char operator) {
        try { // 에러로 인한 중단이 없도록 try catch 문 활용
            OperatorType operatorType = OperatorType.fromSymbol(operator);
            int result = operatorType.apply(num1, num2);
            results.add(result); // 계산된 결과값을 컬렉션 리스트에 담음
            return result; // 결과값을 Main 메서드로 반환
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // 던져둔 예외 메시지 출력
            return 0; // 다시 입력 받을 방법?
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0; // 다시 입력 받을 방법?
        }
    }

    public List<Integer> getResults() { // 게터 메서드
        return results; // 컬렉션 리스트를 반환
    }

    public void setResults(List<Integer> results) { // 세터 메서드
        this.results = results;
    }

    public void removeResult() { // 컬렉션에 저장된 값을 삭제
        results.remove(results.get(0)); // 첫 번째 값이 아니라 입력 값이 삭제되도록 만들 계획
    }

    public int isValid(Scanner scanner, String label) { // 입력값이 양의 정수인지 확인 후 값 반환
        while (true) {
            System.out.print(label + " 숫자를 입력하세요: ");
            try {
                int num = scanner.nextInt(); // 숫자 입력 받기
                if (num < 0) { // 음수인 경우
                    System.out.println("0를 포함한 양의 정수만 입력이 가능합니다.");
                    continue; // 다시 입력 받기
                }
                return num; // 문제없을 시 값 반환!
            } catch (InputMismatchException e) { // 입력값이 숫자가 아닌 경우
                System.out.println("숫자가 아닌 값을 입력하였습니다. 다시 입력해주세요!");
                scanner.next(); // 남아 있는 입력값 제거 ↑위 코드의 println의 ln이 엔터값을 넣어서 에러가 났다.
            }
        }
    }
}
