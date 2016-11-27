package com.igypap.enums.zad3;

import java.util.Scanner;

/**
 * Created by igypap on 26.11.16.
 */
public class Main {

    //TAK, NIE, T, N, YES, NO, OK, SURE, NOPE

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj odpowiedź... ");
        String answer = scanner.next().toUpperCase();
        try {
            System.out.println(Answer.valueOf(answer).stringValue());
        } catch (IllegalArgumentException e) {
            System.out.println("Wprowadzono nieprawidłową odpowiedź");
        }

    }
}
