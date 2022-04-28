package com.company;

import java.util.Scanner;

/**
 * Перевод чисел из десятичной в шестнадцатиричную,
 * из десятичной в двоичную и
 * из двоичной в десятичную.
 */
public class ConvertNumbers {
    //Внутренний сканнер
    private final Scanner scanner;

    //Строка чисел прочитанная с клавиатуры
    String numString;

    //Регуляроное выражение для проверки двоичного числа
    String regexBin = "^[0-1]*$";

    //Регулярное выражение для проверки десятичного числа
    String regexDec = "^([1-9][0-9]{0,3}|10000)$";

    public ConvertNumbers(Scanner scanner) {
        this.scanner = scanner;
    }

    //Метод выводит меню выбора в консоль
    private void printMenu() {
        System.out.println(" Конвертация чисел\n" +
                "Выберите режим, введите:\n" +
                "1 - для конвертации из 10 системы счисления в шеснадцатиричную от 0 до 10000\n" +
                "2 - для конвертации из 10 системы счисления в двоичную от 0 до 10000\n" +
                "3 - для конвертации из двоичной системы счисления в десятичную\n" +
                "4 - для выхода из программы");
    }

    //Выбор режима работы программы
    public void start() {
        if (this.scanner != null) {
            int key;
            do {
                printMenu();
                System.out.print("Введите номер меню: ");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        myDecToHex();
                        break;
                    case 2:
                        myDecToBin();
                        break;
                    case 3:
                        myBinToDec();
                        break;
                    case 4:
                        System.out.println("Завершение программы...");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != 4);
        }
    }

    //Перевод десятичного значения в двоичное
    private void myDecToBin() {
        System.out.println("Введите десятичное число для перевода в двоичную систему счисления " +
                "или введите \"r\" для возврата");
        String num = checkValueOut(regexDec);
        if(num.equals("r")) return;
        System.out.printf("Число %s в двоичной системе: %s\n\n", num, Integer.toBinaryString(Integer.parseInt(num)));
    }

    //Перевод десятичного значения в шестнадцатиричное
    private void myDecToHex() {
        System.out.println("Введите десятичное число для перевода в шеснадцатиричную систему счисления " +
                "или введите \"r\" для возврата");
        String num = checkValueOut(regexDec);
        if(num.equals("r")) return;
        System.out.printf("Число %s в шеснадцатиричной системе: %s\n\n", num, Integer.toHexString(Integer.parseInt(num)));
    }

    //Перевеод двоичного в десятичное
    private void myBinToDec() {
        System.out.println("Введите двоичное число для перевода в десятичную систему счисления " +
                "или введите \"r\" для возврата");
        String num = checkValueOut(regexBin);
        if(num.equals("r")) return;
        System.out.printf("Число %s в десятичной системе: %d\n\n", num, Integer.parseInt(num, 2));
    }

    /**
     * Метод принимает регулярное выражение, производит проверку на корректность ввода
     * исходя из заданого регулярного выражения.
     * Если ввод корректный возвращает введеные данные в String,
     * если ввод не корректный просит пользователя повторить ввод ли бо ввести символ "r" для выхода из данного режима.
     */
    private String checkValueOut(String regex) {
        boolean isCorrect;
        do {
            numString = scanner.next();
            if (numString.equals("r")) return "r";
            isCorrect = numString.matches(regex);
            if (!isCorrect) System.out.println("Введено не корректное число повторите ввод или введите \"r\" для возврата");
        } while (!isCorrect);
        return numString;
    }
}

