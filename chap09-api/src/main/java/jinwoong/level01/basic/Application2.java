package jinwoong.level01.basic;

import java.util.Scanner;

public class Application2 {
    static final String INPUT_MESSAGE = "문자열 입력 : ";
    static final String WORD_COUNT = "%s : %d";
    static final String MODE = "가장 빈도 높은 단어 : %s (%d 번)";

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
         *
         * ----- 출력 예시 -----
         *
         * ===== 단어 빈도 =====
         * hello: 2
         * world: 1
         * everyone: 1
         * 가장 빈도 높은 단어 : hello (2 번)
         */

        System.out.print(INPUT_MESSAGE);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        String[] checkedWords = new String[tokens.length];
        int[] counts = new int[tokens.length];
        int idx = 0;

        for (String token : tokens) {
            String word = token.toLowerCase().replaceAll("[^a-z]+", ""); // 소문자가 아닌 부분을 제거
            if (!word.isEmpty()) {
                int checkedIndex = index(word, checkedWords);
                if (checkedIndex == -1) {
                    checkedWords[idx] = word;
                    counts[idx] += 1;
                    idx += 1;
                } else {
                    counts[checkedIndex] += 1;
                }
            }
        }


        for (int i = 0; i < idx; i++) {
            System.out.printf(WORD_COUNT + "%n", checkedWords[i], counts[i]);
        }
        int maxIndex = getMaxIndex(counts);
        System.out.printf(MODE, checkedWords[maxIndex], counts[maxIndex]);
    }

    public static int index(String word, String[] checkedWords) {
        for (int i = 0; i < checkedWords.length; i++) {
            if (checkedWords[i] != null && checkedWords[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static int getMaxIndex(int[] counts) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            max = Math.max(max, counts[i]);
            index = (max == counts[i]) ? i : index;
        }
        return index;
    }
}