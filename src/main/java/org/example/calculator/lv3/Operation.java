package org.example.calculator.lv3;

public enum Operation { // 연산자 관리 및 연산 수행

    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다."); // 예외 던지기
            }
            return a / b;
    });

    private final char operator;
    private final Calculator cal;

    Operation(char operator, Calculator cal) {
        this.operator = operator;
        this.cal = cal;
    }

    public double apply(double a, double b) { // 전달된 숫자에 대한 연산을 수행하고 반환
        return cal.calculation(a, b);
    }

    public static Operation fromSymbol(char symbol) { // 입력된 연산자 매핑 메서드
        for (Operation op : Operation.values()) {
            // enum 안의 모든 상수를 배열로 반환 → 이유: 연산자가 어떤 상수와 연결될지 찾기 위해
            if (op.operator == symbol) { // enum 상수가 가진 문자와 symbol이 같을 때
                return op; // 그 같은 연산자(enum 상수)를 반환
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다.");
    }

    @FunctionalInterface // 람다식 활용을 위한 함수형 인터페이스
    public interface Calculator {
        double calculation(double a, double b);
    }
}
