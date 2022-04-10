package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new ConvertNumbers(scanner).start();
        scanner.close();
    }

}
