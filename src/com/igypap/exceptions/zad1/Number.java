package com.igypap.exceptions.zad1;

/**
 * Created by igypap on 26.11.16.
 */
public class Number {
    public static double Divide(double a, double b) throws DivideZeroException {
        if (b == 0) {
            throw new DivideZeroException();
        } else {
            return a / b;
        }

    }

}
