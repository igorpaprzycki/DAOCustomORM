package com.igypap.enums.colors;

/**
 * Created by igypap on 26.11.16.
 */
public class ColorExample {

    public static void main(String[] args) {
        Color firstColor = Color.RED;
        Color secondColor = Color.WHITE;
        Color thirdColor = Color.BLUE;

        if (firstColor == secondColor){
            System.out.println("Ten sam kolor");
        }else{
            System.out.println("Kolory się różnią");
        }

        for(Color color : Color.values()){
            System.out.println(color);
        }
        System.out.println(Color.valueOf("RED").ordinal());
    }
}
