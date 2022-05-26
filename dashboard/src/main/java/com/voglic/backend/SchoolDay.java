package com.voglic.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SchoolDay {
    public static ArrayList<Subject> subjects = new ArrayList<Subject>();
    Subject[] subjectArray;

    /**
     * Constructor of the Object, the Object is an array of Subjects
     * @param timetableFile the file of the Timetable from the WebUntisAPI
     */
    SchoolDay(String timetableFile) {
        int length = 0;
        try {
            while (true){
                new Subject(timetableFile, length);
                length++;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Succesfully read the length!");
        }
        subjectArray = new Subject[length];
        for (int i = 0; i < length; i++){
            subjectArray[i] = new Subject(timetableFile, i);
        }
        Arrays.sort(subjectArray, new Sortbystart());
        subjects = new ArrayList<>(Arrays.asList(subjectArray));
        fixLessons();
        subjectArray = subjects.toArray(new Subject[subjects.size()]);
    }

    private static void fixLessons(){
        for(int i = 0; i < subjects.size(); i++){
            for(int j = 0; j < subjects.size(); j++){
                if(subjects.get(i).starttime == subjects.get(j).starttime && i != j){
                    subjects.get(i).teacher += ", " + subjects.get(j).teacher;
                    subjects.remove(j);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SchoolDay: " + Arrays.toString(subjectArray);
    }
}

/**
 * a comparator for the subjects by their starttime
 */
class Sortbystart implements Comparator<Subject> {
    @Override
    public int compare(Subject a, Subject b){
        return a.starttime - b.starttime;
    }
}
