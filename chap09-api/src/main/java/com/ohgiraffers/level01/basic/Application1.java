package com.ohgiraffers.level01.basic;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : I will be a good developer.
         *
         * ----- 출력 예시 -----
         *
         * 변환된 문자열: I Will Be A Good Developer.
         * 총 단어 개수: 6
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String input = scanner.nextLine();

        // String[] words = input.split(" ");
        // 앞뒤 공백 제거 및 연속된 공백을 하나의 구분자로 처리
        String[] words = input.trim().split("\\s+");

        StringBuilder transformedString = new StringBuilder();

        for (String word : words) {
            transformedString.append(capitalizeWord(word)).append(" ");
        }

        if (!transformedString.isEmpty()) {
            // 마지막 공백 제거
            transformedString.setLength(transformedString.length() - 1);
        }

        System.out.println("변환된 문자열 : " + transformedString);
        System.out.println("총 단어 개수 : " + words.length);
    }

    // 단어 첫 글자만 대문자로 만드는 메소드
    private static String capitalizeWord(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}