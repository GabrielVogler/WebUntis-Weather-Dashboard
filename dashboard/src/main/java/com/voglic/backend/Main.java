package com.voglic.backend;

import com.voglic.javaFX.Gui;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Test Subject
        /*Subject am = new Subject("../files/JSON_Stunden/timetable.json", 0);
        System.out.println(am.name);
        System.out.println(am.className);
        System.out.println(am.teacher);
        System.out.println(am.room);
        System.out.println(am.starttime);
        System.out.println(am.endtime);
        System.out.println(am.color);*/
        //System.out.println(new Subject());
        //SchoolDay day = new SchoolDay("../files/JSON_Stunden/timetable.json");
        //System.out.println(day);
        /*WebUntisApi.run();
        day = new SchoolDay("../files/JSON_Stunden/timetable.json");
        System.out.println(day);*/
        System.out.println(Time.get());
        System.out.println(Time.getTime());
        System.out.println(Time.getTimeInt());
        System.out.println(Time.getDate());
        System.out.println(Weather.getWeather("Vienna"));
        System.out.println(Weather.getTemp("Vienna"));
    }
}