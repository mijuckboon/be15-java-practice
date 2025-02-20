package com.ohgiraffers.level02.normal;

public class RandomMaker {

    public static int randomNumber(int min, int max) {

        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static String randomUpperAlphabet(int length) {

        String randomAlpha = "";
        for(int i = 0; i < length; i++) {
            randomAlpha += (char) ((int) (Math.random() * 26 + 'A'));

//			randomAlpha += (char) randomNumber('A', 'Z');
        }

        return randomAlpha;
    }

    public static String rockPaperScissors() {

        int random = (int) (Math.random() * 3);
//		int random = randomNumber(0, 2);

        return random == 0 ? "가위": random == 1 ? "바위" : "보";
    }

    public static String tossCoin() {

        int random = (int) (Math.random() * 2);
//		int random = randomNumber(0, 1);

        return random == 0 ? "앞면" : "뒷면";
    }

}
