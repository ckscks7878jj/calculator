package org.example.calculator.lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArithmeticCalculator {

    private List<Integer> results = new ArrayList<>(); // 이전 연산 결과들을 저장하는 리스트

    // Enum을 활용하여 연산자 타입 관리
    public enum OperatorType {
        PLUS('+'), // ('+' -> a + b) 이런 람다식으로 만들 수 있을까?
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        private char operator; // 속성

        OperatorType(char operator) { // 생성자
            this.operator = operator;
        }

        public char getOperator() { // getOperator를 호출하면
            return operator; // operator를 반환한다.
        }
    }

    public int calculate(int num1, int num2, char operator) { // 입력 받은 숫자와 연산기호로 사칙연산 결과를 반환
        int result = 0;

        OperatorType.PLUS.getOperator(); // + 기호가 반환된다...? 어떻게 써야할까

        OperatorType[] arrayOperatorType = OperatorType.values();
        // 일단 공부해본 내용으로 가져다가 써보긴 했는데, 코드만 길어졌다.
        // scanner를 통해 입력된 사칙연산 기호를 받아 그 기호대로 계산을 하고 결과값을 반환한다...
        // enum 안에서 연산까지 마쳐야하나? 그러려면 어떻게?

        for (OperatorType Ot : arrayOperatorType) {
            switch (Ot) {
                case PLUS:
                    result = num1 + num2;
                    break;
                case MINUS:
                    result = num1 - num2;
                    break;
                case MULTIPLY:
                    result = num1 * num2;
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        return 0; // 첫 숫자 입력으로 돌아가게 만들 계획
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.");
                    return 0; // 다시 사칙연산 기호를 입력 받을 수 있게 만들 계획
            }
        }
        results.add(result); // 계산된 결과값을 컬렉션 리스트에 담음
        return result; // 결과값을 Main 메서드로 반환
    }

    public List<Integer> getResults() { // 값을 가져오는 게터 메서드
        return results;
    }

    public void setResults(List<Integer> results) { // 값을 수정하는 세터 메서드
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
//                break; // 음수도 아니고 예외도 없다면 루프 탈출! → 필요 없어짐
            } catch (InputMismatchException e) { // 입력값이 숫자가 아닌 경우
                System.out.println("숫자가 아닌 값을 입력하였습니다. 다시 입력해주세요!");
                scanner.next(); // 남아 있는 입력값 제거 ↑위 코드의 println의 ln이 엔터값을 넣어서 에러가 났다.
            }
        }
    }
}
