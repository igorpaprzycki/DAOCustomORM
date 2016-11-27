package com.igypap.enums.zad3;

/**
 * Created by igypap on 26.11.16.
 */
public enum Answer {
    TAK(true), NIE(false), T(true), N(false), YES(true), NO(false), Y(true), OK(true), SURE(true), NOPE(false);


    private boolean value;
    Answer(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public String stringValue(){
        if (isValue()){
            return "Poprawna odpowiedź";
        }else{
            return "Niepoprawna odpowiedź";
        }
    }
}
