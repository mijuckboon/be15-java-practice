package jinwoong.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 대기 줄 시뮬레이션
 * 대기 줄을 시뮬레이션하는 프로그램을 작성하세요. 고객이 줄을 서면 대기열에 추가되고, 서비스가 완료되면 대기열에서 제거합니다.
 *
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 유관순
 * 유관순 고객님 대기 등록 되었습니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 홍길동
 * 홍길동 고객님 대기 등록 되었습니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
 * 유관순 고객님 차례입니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 신사임당
 * 신사임당 고객님 대기 등록 되었습니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
 * 홍길동 고객님 차례입니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
 * 신사임당 고객님 차례입니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
 * 대기 고객이 없습니다.
 * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): exit
 */
public class Application3 {
    static final String INPUT = "대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ";
    static final String INSERTED = "%s 고객님 대기 등록되었습니다.%n";
    static final String COMPLETED = "%s 고객님 차례입니다.%n";
    static final String QUEUE_IS_EMPTY = "대기 고객이 없습니다.";

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        Queue<String> queue = new LinkedList<>();

        while (true) {
            input = getInput(INPUT);
            if (input.isBlank()) {
                System.out.println("유효한 이름을 입력해주세요.");
                continue;
            }
            if (input.equals("exit")) {
                break;
            } else if (input.equals("next")) {
                if (queue.isEmpty()) {
                    System.out.println(QUEUE_IS_EMPTY);
                } else {
                    System.out.printf(COMPLETED, queue.poll());
                }
            } else {
                queue.offer(input);
                System.out.printf(INSERTED, input);
            }

        }
    }

    private static String getInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
