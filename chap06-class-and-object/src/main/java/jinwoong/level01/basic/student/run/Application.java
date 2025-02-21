package jinwoong.level01.basic.student.run;

import jinwoong.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    private static final int MAX_DATA = 10;
    private static final String[] INPUT_MESSAGES = {"학년 : ", "반 : ", "이름 : ", "국어점수 : ", "영어점수 : ", "수학점수 : "};
    private static final String INSERT_MESSAGE = "계속 추가할 겁니까 ? (y/n) : ";
    private static final String INVALID_INPUT_MESSAGE = "입력값은 y 또는 n이어야 합니다. 다시 입력해주세요.";

    public static void main(String[] args) {
        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO[] students = new StudentDTO[MAX_DATA];

        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        final Scanner sc = new Scanner(System.in);
        int cnt = 0;
        program:
        while (true) {
            String[] inputs = new String[INPUT_MESSAGES.length];
            for (int i = 0; i < INPUT_MESSAGES.length; i++) {
                System.out.print(INPUT_MESSAGES[i]);
                inputs[i] = sc.nextLine();
            }
            // 한 명씩 추가 될 때마다 카운트함
            students[cnt] = insertStudent(inputs);
            cnt += 1;

            if (cnt == MAX_DATA) {
                for (int i = 0; i < cnt; i++) { // 아래 내용 중복되므로 메서드 분리 해주는 게 좋을 듯함
                    StudentDTO student = students[i];
                    System.out.println(student.getInformation() + ", 평균=" + getAverage(student));
                }
                break program;
            }

            while (true) {
                // 계속 추가할 것인지 물어보고,
                System.out.print(INSERT_MESSAGE);
                String input = sc.nextLine();
                if (!input.matches("[yYnN]")) {
                    System.out.println(INVALID_INPUT_MESSAGE);
                    continue;
                } else {
                    // 대소문자 상관없이 ‘y’이면 계속 객체 추가
                    if (input.matches("[yY]")) {
                        continue program;
                    } else {
                        // 학생들의 정보를 모두 출력 (평균 포함)
                        for (int i = 0; i < cnt; i++) { // 향상된 for 문 사용 시 NullPointerException 발생
                            // 현재 기록된 학생들의 각각의 점수 평균을 구함
                            StudentDTO student = students[i];
                            System.out.println(student.getInformation() + ", 평균=" + getAverage(student));
                        }
                        break program;
                    }
                }

            }


        }


        // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
    }
    public static int convert(String str) {
        return Integer.parseInt(str);
    }

    public static StudentDTO insertStudent(String[] inputs) {
        return new StudentDTO(convert(inputs[0]), convert(inputs[1]), inputs[2], convert(inputs[3]), convert(inputs[4]), convert(inputs[5]));
    }

    public static int getAverage(StudentDTO student) {
        return (student.getKor() + student.getEng() + student.getMath())/3;
    }
}
