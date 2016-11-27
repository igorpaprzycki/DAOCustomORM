package com.igypap.enums.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by igypap on 26.11.16.
 */
public class ColorMap {

    private static Map<String,Integer> colors = new HashMap<String,Integer>();
    static{
        colors.put("RED",0);
        colors.put("WHITE",1);
        colors.put("BLUE",2);
    }
    public static int getValue(String key){
        return colors.get(key);
    }

    public static void main(String[] args) {
        System.out.println(ColorMap.getValue("RED"));

    }
}
