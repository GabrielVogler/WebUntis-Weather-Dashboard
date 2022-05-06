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
    String className;
    int starttime;
    int endtime;
    Color color;

    Subject(String timetableFile, int index) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(timetableFile));
            JSONObject subjectJSON = (JSONObject)((JSONArray) obj).get(index);
            System.out.println(subjectJSON.toString());
            JSONObject first = (JSONObject)((JSONArray)subjectJSON.get("su")).get(0);
            this.name = first.get("name").toString();

            JSONObject second = (JSONObject)(((JSONArray) subjectJSON.get("kl"))).get(0);
            this.className = second.get("name").toString();

            this.teacher = getVariable(subjectJSON, "te", true);
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String  getVariable(JSONObject subjectJSON, String variable, boolean shortName){
        String name = "";
        if(shortName) name = "name";
        else name = "longname";
        return ((JSONObject)(((JSONArray) subjectJSON.get(variable))).get(0)).get(name).toString();
    }
}
