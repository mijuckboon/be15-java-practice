package jinwoong.level01.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 학생 ID 관리
 * 학생들의 ID를 관리하는 프로그램을 작성하세요. 이미 존재하는 ID는 추가하지 않으며, 전체 학생 ID를 출력합니다.
 *
 * 학생 ID 입력('exit' 입력 시 종료): hello
 * ID가 추가 되었습니다.
 * 학생 ID 입력('exit' 입력 시 종료): java
 * ID가 추가 되었습니다.
 * 학생 ID 입력('exit' 입력 시 종료): programmer
 * ID가 추가 되었습니다.
 * 학생 ID 입력('exit' 입력 시 종료): java
 * 이미 등록 된 ID입니다.
 * 학생 ID 입력('exit' 입력 시 종료): exit
 * 모든 학생의 ID : [java, programmer, hello]
 */
public class Application4 {
    static final String INSERT = "학생 ID 입력('exit' 입력 시 종료): ";
    static final String INSERTED = "ID가 추가 되었습니다.";
    static final String DUPLICATE_ID = "이미 등록된 ID입니다.";
    static final String PRINT = "모든 학생의 ID : %s%n";

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String input;
        Set<String> ids = new HashSet<>();
        while (!(input = getInput(INSERT)).equals("exit")) {
            if (input.isBlank()) {
                System.out.println("유효한 ID를 입력해주세요.");
                continue;
            }
            if (ids.contains(input)) {
                System.out.println(DUPLICATE_ID);
            } else {
                ids.add(input);
                System.out.println(INSERTED);
            }
        }
        System.out.printf(PRINT,ids); // ids.toString() 안해도 됨

    }
    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
