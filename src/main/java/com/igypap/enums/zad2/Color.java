package com.igypap.enums.zad2;

/**
 * Created by igypap on 26.11.16.
 */
public enum Color {

    RED(true), GREEN(true), BLUE(true);

    private boolean isNIce;

    Color(boolean isNice) {
        this.isNIce = isNice;
    }

    public boolean isNIce() {
        return isNIce;
    }

    public void setNIce(boolean NIce) {
        isNIce = NIce;
    }

    public void printInformation() {
        if (isNIce()) {
            System.out.println("Kolor jest piękny");
        } else {
            System.out.println("Kolor jest brzydki");
        }

    }
}
