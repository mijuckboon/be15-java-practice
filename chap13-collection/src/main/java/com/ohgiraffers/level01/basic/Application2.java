package com.ohgiraffers.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Application2 {
    public static void main(String[] args) {
        LinkedList<String> urls = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
                String url = scanner.nextLine().trim();

                if (url.equalsIgnoreCase("exit")) {
                    break;
                }

                if (url.isEmpty()) {
                    System.out.println("유효한 URL을 입력하세요.");
                    continue;
                }

                urls.addFirst(url);

                if (urls.size() > 5) {
                    urls.removeLast();
                }

                System.out.println("최근 방문 url : " + urls);
            }
        }
    }
}
