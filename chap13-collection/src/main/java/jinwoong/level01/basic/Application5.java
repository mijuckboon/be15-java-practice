package jinwoong.level01.basic;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 사전순 단어 정렬
 * 사용자가 입력한 단어들을 사전순으로 정렬한 후 출력하는 프로그램을 작성하세요.
 *
 * 단어 입력 ('exit' 입력 시 종료): 안녕
 * 단어 입력 ('exit' 입력 시 종료): java
 * 단어 입력 ('exit' 입력 시 종료): collection
 * 단어 입력 ('exit' 입력 시 종료): 프로그래밍
 * 단어 입력 ('exit' 입력 시 종료): exit
 * 정렬 된 단어 : [collection, java, 안녕, 프로그래밍]
 */
public class Application5 {
    static final String INSERT = "단어 입력 ('exit' 입력 시 종료): ";
    static final String PRINT = "정렬 된 단어 : %s%n";

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>();
        String input;
        while (!(input = getInput(INSERT)).equals("exit")) {
            if (input.isBlank()) {
                System.out.println("유효한 단어를 입력해주세요.");
            } else {
                words.add(input);
            }
        }
        System.out.printf(PRINT, words);



    } private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
