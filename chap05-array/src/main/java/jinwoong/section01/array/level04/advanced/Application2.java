package jinwoong.section01.array.level04.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    static final int LENGTH = 4;
    static final int MAX_CHANCE = 10;
    static final int RANGE_MIN = 0;
    static final int RANGE_MAX = 9;

    static final String NOTICE_MESSAGE = "%d회 남으셨습니다.";
    static final String INPUT_MESSAGE = "%d자리 숫자를 입력하세요.".formatted(LENGTH);
    static final String INVALID_INPUT_MESSAGE = "%d자리의 정수를 입력해야 합니다.".formatted(LENGTH);
    static final String SUCCESS_MESSAGE = "정답입니다.";
    static final String INTERMEDIATE_MESSAGE = "아쉽네요. %dS %dB입니다.";
    static final String FAIL_MESSAGE = "%d번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.".formatted(MAX_CHANCE);

    public static void main(String[] args) {

        /* 숫자 야구게임 만들기
         * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
         * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
         * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
         * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
         *
         * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
         * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
         *
         * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
         * 횟수는 차감하지 않는다.
         *
         * -- 프로그램 예시 (난수 7416 의 경우) --
         *
         * 10회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 1234
         * 아쉽네요 0S 2B 입니다.
         * 9회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 5678
         * 아쉽네요 0S 2B 입니다.
         * 8회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 7416
         * 정답입니다.
         * */

        int length = RANGE_MAX - RANGE_MIN + 1;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = RANGE_MIN + i;
        }
        // 정답이 될 배열 생성
        final int[] generated = getSample(numbers, LENGTH);

        run(generated);
    }

    public static int getRandomNumber(int len) {
        return (int) (Math.random() * len);
    }

    public static int[] getSample(int[] numbers, int size) {
        for (int i = 0; i < numbers.length; i++) {
            int first = getRandomNumber(RANGE_MAX - RANGE_MIN + 1);
            int second = getRandomNumber(RANGE_MAX - RANGE_MIN + 1);

            int tmp = numbers[second];
            numbers[second] = numbers[first];
            numbers[first] = tmp;
        }

        int[] selected = Arrays.copyOf(numbers, size);
        return selected;
    }

    public static int[] convertToArray(String input) {
        int[] converted = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            converted[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return converted;
    }

    public static int[] checkResult(int[] correct, int[] submitted) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < correct.length; i++) {
            for (int j = 0; j < submitted.length; j++) {
                if (correct[i] == submitted[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new int[]{strike, ball};
    }

    public static void run(int[] generated) {
        int chance = MAX_CHANCE;
        while (true) {
            System.out.printf(NOTICE_MESSAGE + "%n", chance);
            System.out.println(INPUT_MESSAGE);

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.length() != 4) {
                System.out.println(INVALID_INPUT_MESSAGE);
                continue;
            }
            int[] submitted = convertToArray(input);
            int[] result = checkResult(generated, submitted);

            if (result[0] == 4) {
                System.out.println(SUCCESS_MESSAGE);
                break;
            } else {
                System.out.printf(INTERMEDIATE_MESSAGE + "%n", result[0], result[1]);
                chance -= 1;
                if (chance > 0) {
                    continue;
                } else {
                    System.out.println(FAIL_MESSAGE);
                    break;
                }

            }


        }


    }
}