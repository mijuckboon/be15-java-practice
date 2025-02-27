package com.ohgiraffers.level01.basic;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("단어 입력 ('exit' 입력 시 종료): ");
                String word = scanner.nextLine().trim();

                if (word.equals("exit")) {
                    break;
                }

                if (word.isEmpty()) {
                    System.out.println("유효한 단어를 입력하세요.");
                    continue;
                }

                words.add(word);
            }
        }

        System.out.println("정렬 된 단어 : " + words);
    }
}
