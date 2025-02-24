package com.ohgiraffers.level01.basic.student.run;

import java.util.Scanner;

import com.ohgiraffers.level01.basic.student.model.dto.StudentDTO;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDTO[] students = new StudentDTO[10];

        int index = 0;

        while(index < students.length){

            System.out.print("학년: ");
            int grade = sc.nextInt();

            System.out.print("반: ");
            int classroom = sc.nextInt();
            sc.nextLine();

            System.out.print("이름 : ");
            String name = sc.nextLine();

            System.out.print("국어점수 : ");
            int kor = sc.nextInt();

            System.out.print("영어점수 : ");
            int eng = sc.nextInt();

            System.out.print("수학점수 : ");
            int math = sc.nextInt();
            sc.nextLine();

            students[index++] = new StudentDTO(grade, classroom, name, kor, eng, math);

            System.out.print("계속 추가할 겁니까? (y/n) : ");
            //char anwser = sc.nextLine().toUpperCase().charAt(0);
            //if(anwser != 'Y') break;

            String anwser = sc.nextLine();
            if(!anwser.equalsIgnoreCase("y")) break;
        }


        for(int i = 0; i < index; i++) {
            int sum = students[i].getKor() + students[i].getEng() + students[i].getMath();
            System.out.println(students[i].getInformation() + ", 평균=" + sum/3);
        }

    }

}