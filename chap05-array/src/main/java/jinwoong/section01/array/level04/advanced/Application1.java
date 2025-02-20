package jinwoong.section01.array.level04.advanced;

import java.util.Arrays;

public class Application1 {
    static final int RANGE_MIN = 1;
    static final int RANGE_MAX = 45;
    static final int PICK = 6;

    public static void main(String[] args) {

        /* 로또번호 생성기
         * 6칸 짜리 정수 배열을 하나 생성하고
         * 1부터 45까지의 중복되지 않는 난수를 발생시켜 각 인덱스에 대입한 뒤
         * 오름차순 정렬하여 출력하세요.
         * Arrays.sort(배열) 메소드 활용하여 정렬 가능.
         * */

        /* 배열 선언 후 shuffle -> 6개만 따옴 */

        int length = RANGE_MAX - RANGE_MIN + 1;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = RANGE_MIN + i;
        }

        for (int i = 0; i < length; i++) {
            int first = getRandomNumber(length);
            int second = getRandomNumber(length);

            int tmp = numbers[second];
            numbers[second] = numbers[first];
            numbers[first] = tmp;
        }

        int[] selected = Arrays.copyOf(numbers, PICK);
        Arrays.sort(selected);
        System.out.println(Arrays.toString(selected));

    }

    public static int getRandomNumber(int len) {
        return (int) (Math.random() * len);
    }

//    public static int getRandomNumber(int min, int max) {
//        return (int) (Math.random() * (max - min + 1) + min);
//    }

}