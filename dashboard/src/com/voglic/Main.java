package com.voglic;

public class Main {
    public static void main(String[] args) {
        Subject am = new Subject("../files/JSON_Stunden/timetable.json", 0);
        System.out.println(am.name);
        System.out.println(am.className);
        System.out.println(am.teacher);
    }
}