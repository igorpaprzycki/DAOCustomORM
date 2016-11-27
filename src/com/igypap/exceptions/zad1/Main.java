package com.igypap.exceptions.zad1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        try {
            System.out.println(Number.Divide(a,b));
        } catch (DivideZeroException e) {
            System.out.println("Co poszło nie tak! " + e.getMessage());
        }
    }
}
