package com.voglic;

public class Main {
    public static void main(String[] args) {
        //Test Subject
        /*Subject am = new Subject("../files/JSON_Stunden/timetable.json", 0);
        System.out.println(am.name);
        System.out.println(am.className);
        System.out.println(am.teacher);
        System.out.println(am.room);
        System.out.println(am.starttime);
        System.out.println(am.endtime);
        System.out.println(am.color);*/
        SchoolDay day = new SchoolDay("../files/JSON_Stunden/timetable.json");

        for (int i = 0; i < day.subjects.length;  i++){
            System.out.println(day.subjects[i].name);
        }
    }
}