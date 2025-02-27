package com.ohgiraffers.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application6 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
                String input = scanner.nextLine().trim();
                if (input.equals("exit")) {
                    break;
                }

                if (input.equals("search")) {
                    System.out.print("검색 할 이름 : ");
                    String name = scanner.nextLine().trim();
                    String phoneNumber = phoneBook.get(name);
                    if (phoneNumber != null) {
                        System.out.println(name + "씨의 전화번호 : " + phoneNumber);
                    } else {
                        System.out.println(name + "씨의 번호는 등록 되어 있지 않습니다.");
                    }
                } else {
                    String[] entry = input.split("\\s+");
                    if (entry.length == 2) {
                        phoneBook.put(entry[0], entry[1]);
                        System.out.println("추가 완료 : " + entry[0] + " " + entry[1]);
                    } else {
                        System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
                    }
                }
            }
        }
    }
}
