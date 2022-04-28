package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConvertNumbers convertNumbers = new ConvertNumbers(scanner);
        convertNumbers.start();
        scanner.close();
    }

}
