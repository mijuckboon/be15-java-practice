package jinwoong.level01.basic;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 최근 방문한 URL 기록
 * 사용자가 방문한 웹사이트 URL을 입력받아 저장하고, 가장 최근에 방문한 5개의 URL을 출력하는 프로그램을 작성하세요.
 *
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
 * 최근 방문 url : [https://www.google.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
 * 최근 방문 url : [https://github.com/, https://www.google.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.notion.so/
 * 최근 방문 url : [https://www.notion.so/, https://github.com/, https://www.google.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.naver.com/
 * 최근 방문 url : [https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
 * 최근 방문 url : [https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
 * 최근 방문 url : [https://www.google.com/, https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/]
 * 방문 URL을 입력하세요 (단, exit를 입력하면 종료) : exit
 */

public class Application2 {
    static final String INPUT = "URL을 입력하세요 (단, exit를 입력하면 종료) : ";
    static final String RECENT = "최근 방문 url : ";
    static final int MAX = 5;
    static final String REGEX_URL = ""; // TODO: 적당한 URL 정규표현식 찾아서 검증 로직 구현

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> urls = new LinkedList<>(); // 역방향
        String input;
        while (!(input = getInput(INPUT)).equals("exit")) {
            if (!input.isBlank()) {
                urls.addFirst(input);
            } else {
                System.out.println("유효한 URL을 입력해주세요.");
            }
            System.out.println(RECENT + urls.subList(0, Math.min(urls.size(),MAX)));
        }


    }
    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
