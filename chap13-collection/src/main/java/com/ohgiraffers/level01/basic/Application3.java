package com.ohgiraffers.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else if (input.equalsIgnoreCase("next")) {
                    if (queue.isEmpty()) {
                        System.out.println("대기 고객이 없습니다.");
                    } else {
                        System.out.println(queue.poll() + " 고객님 차례입니다.");
                    }
                } else if (input.isEmpty()) {
                    System.out.println("유효한 이름을 입력하세요.");
                } else {
                    queue.add(input);
                    System.out.println(input + " 고객님 대기 등록 되었습니다.");
                }
            }
        }
    }
}
