package com.voglic.backend;

import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Subject {
    public String name;
    String teacher;
    String room;
    String className;
    int starttime;
    int endtime;
    public Color color;

    public Subject(String timetableFile, int index) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(timetableFile));
            JSONObject subjectJSON = (JSONObject) ((JSONArray) obj).get(index);
            this.name = getVariable(subjectJSON, "su");
            this.className = getVariable(subjectJSON, "kl");
            this.teacher = getVariable(subjectJSON, "te");
            this.room = getVariable(subjectJSON, "ro");
            this.starttime = Integer.parseInt(getVariable(subjectJSON, "startTime", true));
            this.endtime = Integer.parseInt(getVariable(subjectJSON, "endTime", true));
            this.color = getColor();
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getVariable(JSONObject subjectJSON, String variable, boolean ifTime, boolean shortName) {
        String nameSwitch = "";
        if (shortName) nameSwitch = "name";
        else nameSwitch = "longname";
        if (ifTime) return subjectJSON.get(variable).toString();
        else return ((JSONObject) (((JSONArray) subjectJSON.get(variable))).get(0)).get(nameSwitch).toString();
    }
    private static String getVariable(JSONObject subjectJSON, String variable, boolean ifTime) {
        return getVariable(subjectJSON, variable, ifTime, true);
    }
    private static String getVariable(JSONObject subjectJSON, String variable) {
        return getVariable(subjectJSON, variable, false, true);
    }

    private Color getColor(){
        switch (name){
            case "D" -> {return Color.ORANGE;}
            case "BW" -> {return Color.PURPLE;}
            case "GETE" -> {return Color.BROWN;}
            case "BSPK" -> {return Color.GREEN;}
            case "BS" -> {return Color.MEDIUMPURPLE;}
            case "COPR" -> {return Color.DARKBLUE;}
            case "AM" -> {return Color.LIGHTYELLOW;}
            case "SEW" -> {return Color.LIGHTGREEN;}
            case "CH" -> {return Color.MEDIUMBLUE;}
            case "GGP" -> {return Color.LIGHTBLUE;}
            case "E" -> {return Color.BLUE;}
            case "GINF" -> {return Color.YELLOW;}
            case "RK" -> {return Color.MEDIUMSEAGREEN;}
            case "MEDT" -> {return Color.PINK;}
            case "NWT" -> {return Color.VIOLET;}
            case "ITSI" -> {return Color.YELLOWGREEN;}
            default -> {return Color.LIGHTGRAY;}
        }
    }

    @Override
    public String toString() {
        return name + ": " + starttime;
    }
}