package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                Конвертация чисел
                выберите режим, введите:
                16 - для конвертации из 10 системы счисления в шеснадцатиричную
                2 - для конвертации из 10 системы счисления в двоичную
                10 - для конвертации из двоичной системы счисления в десятичную
                -1 - для выхода из программы""");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        while (option != -1) {
            if (option == 16) {
                myToHex();
                break;
            } else if (option == 2) {
                myDecToBin();
                break;
            } else if (option == 10) {
                myToBinary();
                break;
            } else {
                System.out.println("Повторите ввод");
                option = in.nextInt();
            }
        }

        System.out.println("Программа завершает работу");
        in.close();


    }

    private static void myDecToBin() {
        System.out.println("Введите десятичное число для перевода в двоичную систему исчисления");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        System.out.printf("Число %d в двоичной системе: ", num);
        System.out.println(Integer.toBinaryString(num));
    }

    private static void myToBinary() {
        System.out.println("Введите двоичное число для перевода в десятичную систему исчисления");
        Scanner in = new Scanner(System.in);
        String numString = in.next();
        in.close();

        int nBinary = 0;
        for (int i = numString.length() - 1, j = 1; i >= 0; i--, j *= 2) {
            nBinary += (numString.charAt(i) - '0') * j;
        }
        System.out.printf("Число %s в десятичной системе: %d", numString, nBinary);


    }

    private static void myToHex() {
        System.out.println("Введите десятичное число для перевода в шеснадцатиричное");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        System.out.printf("Число %d в шеснадцатиричной системе: ", num);
        System.out.println(Integer.toHexString(num));
    }


}
