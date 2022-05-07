package com.voglic;

import java.util.Arrays;

public class SchoolDay {
    Subject[] subjects;

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
        subjects = new Subject[length];
        for (int i = 0; i < length; i++){
            subjects[i] = new Subject(timetableFile, i);
            System.out.println(subjects[i].name);
            System.out.println(subjects[i].starttime);
        }
        Arrays.sort(subjects, new Sortbystart());
    }
}
