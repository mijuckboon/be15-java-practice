package jinwoong.level01.basic;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Application2 {
    static final String INPUT_MESSAGE = "생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ";
    static final String ALLOW_ENTER = "입장하셔도 됩니다.";
    static final String INVALID_INPUT = "날짜 양식을 잘못 입력하셨습니다.";
    static final int THRESHOLD = 20;
    static final String ERROR_MESSAGE = "만 %s세 미만은 입장 불가입니다.".formatted(THRESHOLD);

    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        /* ----- 입력 예시 -----
         *
         * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 2014-05-05
         *
         * ----- 출력 예시 -----
         *
         * 만 20세 미만은 입장 불가입니다.
         *
         * ----- 입력 예시 -----
         *
         * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 1994-05-05
         *
         * ----- 출력 예시 -----
         *
         * 입장하셔도 됩니다.
         *
         * ----- 입력 예시 -----
         *
         * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 2000-14-15
         *
         * ----- 출력 예시 -----
         *
         * 날짜 양식을 잘못 입력하셨습니다.
         */

        try {
            Application2 app = new Application2();
            String input = app.getInput(INPUT_MESSAGE);
            LocalDate birthDate = LocalDate.parse(input);
            LocalDate today = LocalDate.now();
            Period timeDiff = birthDate.until(today);
            if (timeDiff.getYears() < THRESHOLD) {
                throw new InvalidAgeException(ERROR_MESSAGE);
            }
            System.out.println(ALLOW_ENTER);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (DateTimeException e) {
            System.out.println(INVALID_INPUT);
        }

    }
    public String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

}