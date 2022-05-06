package com.voglic;

public class Main {
    public static void main(String[] args) {
        Subject am = new Subject("../files/JSON_Stunden/timetable.json");
        System.out.println(am.name);
    }
}