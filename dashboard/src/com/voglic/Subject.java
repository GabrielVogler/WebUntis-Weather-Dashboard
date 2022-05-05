package com.voglic;

import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Subject {
    String name;
    String teacher;
    String room;
    int starttime;
    int endtime;
    Color color;

    Subject(String timetableFile) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(timetableFile));
            JSONArray array = (JSONArray) obj;
            JSONObject first = (JSONObject) array.get(0);
            System.out.println(first);
            System.out.println(first.get("su"));
            JSONObject firstt = (JSONObject) first.get("su");
            System.out.println(firstt.get(name));
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
