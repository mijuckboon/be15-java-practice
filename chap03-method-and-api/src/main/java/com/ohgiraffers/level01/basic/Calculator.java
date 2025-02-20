package com.ohgiraffers.level01.basic;

public class Calculator {

    public void checkMethod(){

        System.out.println("메소드 호출 확인");

    }

    public int sum1to10(){
        int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;

		/*
		int sum = 0;

		for(int i = 0; i <= 10; i++){
			sum += i;
		}
		*/

        return sum;
    }

    public void checkMaxNumber(int a, int b){
        int max = a > b ? a : b;

        System.out.println("두 수 중 큰 수는 " + max + "이다.");
    }

    public int sumTwoNumber(int a, int b){
        int sum = a + b;

        return sum;
    }

    public int minusTwoNumber(int a, int b){

        return a - b;
    }

}
