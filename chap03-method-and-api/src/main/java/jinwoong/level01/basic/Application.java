package jinwoong.level01.basic;

public class Application {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.checkMethod();
        System.out.println("1부터 10까지의 합 : " + calc.sum1to10());
        calc.checkMaxNumber(10, 20);
        int a = 10;
        int b = 20;
        System.out.println(a + "과 " + b + "의 합은 : " + calc.sumTwoNumber(a, b));
        b = 5;
        System.out.println(a + "과 " + b + "의 차는 : " + calc.minusTwoNumber(a, b));

    }
}
