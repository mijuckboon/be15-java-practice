package jinwoong.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 전화번호부
 * 이름을 입력하면 전화번호를 검색할 수 있도록 전화번호부를 구현하세요.
 * <p>
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동010-1234-5678
 * 입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동 010-1234-5678
 * 추가 완료 : 홍길동 010-1234-5678
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 유관순 010-9876-5432
 * 추가 완료 : 유관순 010-9876-5432
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
 * 검색 할 이름 : 유관순
 * 유관순씨의 전화번호 : 010-9876-5432
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
 * 검색 할 이름 : 이순신
 * 이순신씨의 번호는 등록 되어 있지 않습니다.
 * 이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): exit
 */
public class Application6 {
    static final String INSERT = "이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ";
    static final String INVALID_INPUT = "입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호: 01x-xxxx-xxxx>";
    static final String INSERT_COMPLETE = "추가 완료 : %s%n";
    static final String NAME_TO_SEARCH = "검색할 이름 : ";
    static final String SEARCHED_NUMBER = "%s씨의 전화번호 : %s%n";
    static final String NOT_REGISTERED = "%s씨의 번호는 등록 되어 있지 않습니다.%n";

    static final String REGEX_PHONE_NUMBER = "01[0-9]-[0-9]{3,4}-[0-9]{4}"; // 더 다양한 경우도 가능하겠지만 우선 이 정도만 구현 (ex. +82-10-xxxx-xxxx)

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        Map<String, String> numbers = new HashMap<>();
        // 이름을 검색 조건으로 사용하므로 동명이인은 없다고 가정 (만약 동명이인이 있다면 전화번호가 덮어쓰기 되므로 다른 방법 필요)

        while (true) {
            input = getInput(INSERT);
            if (input.equals("exit")) {
                break;
            } else if (input.equals("search")) {
                input = getInput(NAME_TO_SEARCH);
                if (numbers.containsKey(input)) {
                    System.out.printf(SEARCHED_NUMBER, input, numbers.get(input));
                } else {
                    System.out.printf(NOT_REGISTERED, input);
                }
            } else {
                String[] keyValue = getPair(input);
                if (keyValue != null && keyValue[1].matches(REGEX_PHONE_NUMBER)) {
                    numbers.put(keyValue[0], keyValue[1]);
                    System.out.printf(INSERT_COMPLETE, input);
                } else {
                    System.out.println(INVALID_INPUT);
                }
            }
        }
    }

    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();

    }

    private static String[] getPair(String input) {
        String[] pair = input.split(" ");
        if (pair.length == 2) {
            return pair;
        }
        return null;
    }

}
