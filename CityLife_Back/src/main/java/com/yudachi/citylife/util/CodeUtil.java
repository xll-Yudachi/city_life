package com.yudachi.citylife.util;

import java.util.Random;

public class CodeUtil {
    public static String genCode_6(){
        String sources = "0123456789";
        Random rand = new Random();
        StringBuffer res = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            res.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return res.toString();
    }
}
