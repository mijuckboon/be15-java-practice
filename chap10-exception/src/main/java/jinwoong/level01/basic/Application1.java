package jinwoong.level01.basic;

import java.util.Scanner;

public class Application1 {
    static final String INSERT_NUMERATOR = "분자 입력 : ";
    static final String INSERT_DENOMINATOR = "분모 입력 : ";
    static final String RESULT = "결과 : %s %n";
    static final String COMPLETED = "실행이 완료되었습니다.";
    static final String ERROR = "오류 : %s %n";
    static final String INVALID_INPUT = "유효한 정수를 입력하세요.";
    static final String DIV_BY_ZERO = "0으로 나누는 것은 허용되지 않습니다.";

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 분자 입력 : 10
         * 분모 입력 : 2
         *
         * ----- 출력 예시 -----
         *
         * 결과 : 5
         * 실행이 완료되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * 분자 입력 : 십
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 유효한 정수를 입력하세요.
         * 실행이 완료되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * 분자 입력 : 10
         * 분모 입력 : 0
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 0으로 나누는 것은 허용되지 않습니다.
         * 실행이 완료되었습니다.
         */
        Application1 app = new Application1();
        try {
            int numerator = Integer.parseInt(app.getInput(INSERT_NUMERATOR));
            int denominator = Integer.parseInt(app.getInput(INSERT_DENOMINATOR));
            if (denominator == 0) {
                throw new ArithmeticException(DIV_BY_ZERO);
            }
            double result = app.divide(numerator,denominator);
            System.out.printf(RESULT, result);
        } catch (IllegalArgumentException e) {
            System.out.printf(ERROR, INVALID_INPUT);
        } catch (ArithmeticException e) {
            System.out.printf(ERROR, e.getMessage());
        } finally {
            System.out.println(COMPLETED);
        }

    }

    public String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public double divide(int dividend, int divisor) {
        return (double) dividend / divisor;
    }

}

