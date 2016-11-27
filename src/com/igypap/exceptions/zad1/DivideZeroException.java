package com.igypap.exceptions.zad1;

/**
 * Created by igypap on 26.11.16.
 */
public class DivideZeroException extends Exception {


    @Override
    public String getMessage(){
        return "Nie można dzielić przez 0!";
    }
}
