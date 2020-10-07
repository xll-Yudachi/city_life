package com.yudachi.citylife.constant;

import java.util.HashMap;
import java.util.Map;

public class ApplicationMap {
    private static Map<String, String> map = new HashMap<>();
    static {
         /* application/msword
            application/vnd.openxmlformats-officedocument.wordprocessingml.document
            application/pdf */
        map.put("application/msword","doc");
        map.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document","docx");
        map.put("application/pdf","pdf");
    }
    public static String getByMediaType(String mediaType){
        return map.get(mediaType);
    }

}
