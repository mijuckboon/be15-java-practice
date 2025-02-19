package jinwoong.level02.normal;

public class RandomMaker {
    public static int randomNumber(int min, int max) {
        return (int) (Math.random()*(max-min+1)) + min;
    }

    public static String randomUpperAlphabet(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            int randint = 64 + randomNumber(1,26);
            sb.append((char)randint);
        }
        return sb.toString();
    }
    public static String rockPaperScissors() {
        int randint = randomNumber(0, 2);
        if (randint == 0) {
            return "가위";
        }
        if (randint == 1) {
            return "바위";
        }
        return "보";
    }

    public static String tossCoin() {
        String face = "면";
        int randint = randomNumber(0, 1);
        if (randint == 0) {
            return "앞" + face;
        }
        return "뒷" + face;

    }
}
