package com.lamnt.foodorder.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
    public static String appendEndPoint(String... strings) {
        StringBuilder builder = new StringBuilder();
        int length = strings.length;
        for (int i = 0; i < length; i++) {
            if (i<length-1){
                builder.append("/").append(strings[i]);
            }else {
                builder.append(strings[i]);
            }
        }
        return builder.toString();
    }

    public static String appendEndPoint(HashMap<String, String> request) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : request.entrySet()){
            builder.append(entry.getKey()).append("/").append(entry.getValue());
        }
        return builder.toString();
    }
}
