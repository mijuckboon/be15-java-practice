package jinwoong.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application2 {
    static final String INPUT_NAME_OF_ORIGINAL = "원본 파일의 이름을 입력하세요 : ";
    static final String INPUT_NAME_OF_COPY = "복사 파일의 이름을 입력하세요 : ";
    static final String SUCCESS = "파일 복사가 성공적으로 완료 되었습니다.";
    static final String CANNOT_FIND_ERROR = "오류 : %s (지정된 파일을 찾을 수 없습니다)";

    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (원본 파일이 존재 하는 경우)
         * 원본 파일의 이름을 입력하세요 : origin.txt
         * 복사 파일의 이름을 입력하세요 : copy.txt
         *
         * ----- 출력 예시 -----
         *
         * 파일 복사가 성공적으로 완료 되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * (원본 파일이 존재하지 않는 경우)
         * 원본 파일의 이름을 입력하세요 : origin2.txt
         * 복사 파일의 이름을 입력하세요 : copy2.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : origin2.txt (지정된 파일을 찾을 수 없습니다)
         *
         */

        Application2 app = new Application2();
        String originalName = app.getInput(INPUT_NAME_OF_ORIGINAL);
        String copyName = app.getInput(INPUT_NAME_OF_COPY);

        try {
        FileReader fr = new FileReader(originalName);
        File originalFile = new File(originalName);
        int len = (int) originalFile.length();
        char[] contents = new char[len];
        fr.read(contents);
        fr.close();

        File copyFile = new File(copyName);
        copyFile.createNewFile();
        FileWriter fw = new FileWriter(copyFile);

        for (char content : contents) {
            if (content != 0) {
                fw.write(content);
            }
        }
        fw.flush();
        fw.close();
        System.out.println(SUCCESS);

        } catch (FileNotFoundException e) {
            System.out.printf(CANNOT_FIND_ERROR, originalName);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    } public String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}