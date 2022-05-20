package com.voglic.backend;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Time {
    public static String get(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public static String getDate(){
        String[] result = get().split(" ");
        return result[0];
    }
    public static String getTime(){
        String[] result = get().split(" ");
        return result[1];
    }
}
