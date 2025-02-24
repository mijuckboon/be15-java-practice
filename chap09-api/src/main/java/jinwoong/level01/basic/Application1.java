package jinwoong.level01.basic;

import java.util.Scanner;

public class Application1 {
    static final String INPUT_MESSAGE = "문자열 입력 : ";
    static final String OUTPUT_TRANSFORMED = "변환된 문자열 : ";
    static final String OUTPUT_COUNT = "총 단어 개수 : ";

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : I will be a good developer.
         *
         * ----- 출력 예시 -----
         *
         * 변환된 문자열: I Will Be A Good Developer.
         * 총 단어 개수: 6
         */
        System.out.print(INPUT_MESSAGE);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        StringBuilder[] builders = new StringBuilder[tokens.length];
        StringBuilder print = new StringBuilder(OUTPUT_TRANSFORMED);
        for (int i = 0; i < tokens.length; i++) {
            StringBuilder sb = new StringBuilder(tokens[i]);
            builders[i] = sb;
            sb.replace(0,1,sb.substring(0,1).toUpperCase());
            print.append(sb);
            print.append(" ");
        }

        System.out.println(print.toString().trim());
        System.out.println(OUTPUT_COUNT + tokens.length);

    }
}