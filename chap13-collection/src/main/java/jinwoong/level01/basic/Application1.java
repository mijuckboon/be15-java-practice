package jinwoong.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 점수 평균 구하기
 * 학생들의 점수를 입력받아 저장한 후, 평균 점수를 계산하여 출력하는 프로그램을 작성하세요.
 *
 * 학생 성적 : 100
 * 추가 입력하려면 y : y
 * 학생 성적 : 95
 * 추가 입력하려면 y : Y
 * 학생 성적 : 66
 * 추가 입력하려면 y : y
 * 학생 성적 : 79
 * 추가 입력하려면 y : n
 * 학생 인원 : 4
 * 평균 점수 : 85.0
 */

public class Application1 {
    enum Message {
        INPUT_GRADE("학생 성적 : "), INSERT("추가 입력하려면 y : "),
        STUDENT_COUNT("학생 인원 : %d%n"), AVERAGE("평균 점수 : %f%n");

        String message;

        Message(String message) {
            this.message = message;
        }
    }
   static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>(); // 평균 구할 때 순회
        String input;
        while (true) {
            try {
                Integer grade = Integer.parseInt(getInput(Message.INPUT_GRADE.message));
                if (grade < 0) {
                    throw new NumberFormatException();
                }
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("성적은 0 이상의 자연수 값이어야 합니다.");
                continue;
            }
            input = getInput(Message.INSERT.message);
            if (!input.equalsIgnoreCase("y")) {
                break;
            }
        }
        System.out.printf(Message.STUDENT_COUNT.message, grades.size());
        System.out.printf(Message.AVERAGE.message, getAverage(grades));

    }

    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    private static double getAverage(List<Integer> grades) {
        return (double) grades.stream().mapToInt(x -> x).sum() / grades.size();
    }

}
