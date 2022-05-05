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
            JSONArray array2 = (JSONArray) first.get("su");
            JSONObject obj2 = (JSONObject) array2.get(0);
            this.name = obj2.get("name").toString();
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
