package jinwoong.section02.dimensional_array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application1 {
    static final String ROW_INPUT_MESSAGE = "가로 행의 수를 입력하세요 : ";
    static final String COLUMN_INPUT_MESSAGE = "세로 열의 수를 입력하세요 : ";
    static final String INVALID_INPUT_MESSAGE = "반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.";

    public static void main(String[] args) {

        /* 가로와 세로 길이를 정수형으로 입력 받아
         * 입력받은 가로 세로 길이를 이용하여 이차원 배열을 할당하고
         * 각 인덱스에는 랜덤으로 알파벳 대문자 넣어서 출력
         *
         * 단, 가로 행 혹은 세로 열은 반드시 1~10 까지의 정수를 입력해야 하고
         * 그렇지 않은 경우에는 "반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요." 출력 후
         * 가로 행 또는 세로 열을 다시 입력받을 수 있도록 한다.
         *
         * -- 입력 예시 --
         * 가로 행의 수를 입력하세요 : 5
         * 세로 열의 수를 입력하세요 : 4
         *
         * -- 출력 예시 --
         * F H Z G
         * W F O T
         * O R X V
         * W H J X
         * W S S J
         * */

        Scanner sc = new Scanner(System.in);

        int row_count;
        int column_count;

        while (true) {
            System.out.print(ROW_INPUT_MESSAGE);
            row_count = sc.nextInt();
            if (!isValid(row_count)) {
                System.out.println(INVALID_INPUT_MESSAGE);
                continue;
            }
            System.out.print(COLUMN_INPUT_MESSAGE);
            column_count = sc.nextInt();
            if (!isValid(column_count)) {
                System.out.println(INVALID_INPUT_MESSAGE);
                continue;
            }
            if (isValid(row_count) && isValid(column_count)) {
                break;
            }
        }

        char[][] chars = new char[row_count][column_count];

        for (int i = 0; i < row_count; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < column_count; j++) {
                chars[i][j] = getRandomChar();
                sb.append(chars[i][j]);
                sb.append(' ');
            }
            System.out.println(sb.toString().trim());
        }

    }
    public static boolean isValid(int number) {
        if (number >= 1 && number <= 10) {
            return true;
        }
        return false;
    }

    public static char getRandomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

}