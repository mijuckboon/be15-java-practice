package jinwoong.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application1 {
    static final String INPUT_FILE_NAME = "파일 이름을 입력하세요 : ";
    static final String INVALID_FILE_NAME = "오류 : 해당 이름을 가진 파일이 없습니다.";

    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (존재하는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : hello.txt
         *
         * ----- 출력 예시 -----
         *
         * ===== 파일 내용 출력 =====
         * 안녕하세요. 반갑습니다. 제 이름은 홍길동입니다.
         *
         * ----- 입력 예시 -----
         *
         * (존재하지 않는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : unknown.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 해당 이름을 가진 파일이 없습니다.
         *
         */
        Application1 app = new Application1();
        String fileName = app.getInput(INPUT_FILE_NAME);

        try (FileReader fr = new FileReader(fileName) ) {
            int len = (int) (new File(fileName)).length();
            char[] contents = new char[len];
            fr.read(contents);
            for (char content : contents) {
                System.out.print(content);
            }

        } catch (FileNotFoundException e) {
            System.out.println(INVALID_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } public String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
