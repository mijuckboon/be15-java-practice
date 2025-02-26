package jinwoong.level02.normal;

import java.io.*;
import java.util.Scanner;

/**
 * 입출력 예시
 * 병합할 파일의 개수 입력 : 3
 * 1 번째 파일 이름 입력 : test.txt
 * 2 번째 파일 이름 입력 : test2.txt
 * 3 번째 파일 이름 입력 : test3.txt
 * 병합 될 파일명 입력 : result.txt
 * 파일 병합이 완료 되었습니다.
 * ------------------------------
 * 병합할 파일의 개수 입력 : 2
 * 1 번째 파일 이름 입력 : test.txt
 * 2 번째 파일 이름 입력 : test4.txt
 * 병합 될 파일명 입력 : result.txt
 * 오류 : test4.txt (지정된 파일을 찾을 수 없습니다)
 */

public class Application {
    static final String NUMBER_OF_FILES = "병합할 파일의 개수";
    static final String INPUT_MESSAGE = "%s 입력 : ";
    static final String FILENAME = "%s 번째 파일 이름";
    static final String NAME_OF_MERGED_FILE = "병합 될 파일명";
    static final String COMPLETED = "파일 병합이 완료되었습니다.";
    static final String INVALID_INPUT = "오류 : %s (지정된 파일을 찾을 수 없습니다)";

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        int numberOfFiles = Integer.parseInt(getInput(INPUT_MESSAGE.formatted(NUMBER_OF_FILES)));

        String[] fileNames = new String[numberOfFiles];
        for (int i = 1; i <= numberOfFiles; i++) {
            fileNames[i - 1] = getInput(INPUT_MESSAGE.formatted(FILENAME.formatted(i)));
        }

        String mergedFileName = getInput(INPUT_MESSAGE.formatted(NAME_OF_MERGED_FILE));

        StringBuilder sb = new StringBuilder();

        try {
            for (int i = 0; i < numberOfFiles; i++) {
                String fileName = fileNames[i];
                br = new BufferedReader(new FileReader(fileName));
                if (!(new File(fileName)).exists()) {
                    throw new FileNotFoundException(INVALID_INPUT.formatted(fileName));
                }

                bw = new BufferedWriter(new FileWriter(mergedFileName));
                String read;
                while ((read = br.readLine()) != null) {
                    sb.append(read).append(System.lineSeparator());
                }
            }
            br.close();
            bw.write(sb.toString());
            bw.close();
            System.out.println(COMPLETED);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
