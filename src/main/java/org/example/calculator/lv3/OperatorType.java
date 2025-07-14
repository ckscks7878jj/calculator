package org.example.calculator.lv3;

public enum OperatorType {

    PLUS('+') { // 추상 메서드를 구체화 (공통의 인터페이스를 두고 각각 기능 구현)
        public int apply(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        public int apply(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        public int apply(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        public int apply(int num1, int num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다."); // 예외 던지기
            } else {
                return num1 / num2;
            }
        }
    };

    private char operator; // 속성

    OperatorType(char operator) { // 생성자
        this.operator = operator;
    }

    public abstract int apply(int x, int y); // 추상 메서드, 다형성

    public static OperatorType fromSymbol(char symbol) { // 입력된 연산자 매핑 메서드
        for (OperatorType op : OperatorType.values()) {
            // enum 안의 모든 상수를 배열로 반환 → 이유: 연산자가 어떤 상수와 연결될지 찾기 위해
            if (op.operator == symbol) { // enum 상수가 가진 문자와 symbol이 같을 때
                return op; // 그 같은 연산자(enum 상수)를 반환
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다.");
    }
}
