package com.voglic;

import java.util.Comparator;

public class Sortbystart implements Comparator<Subject> {
    @Override
    public int compare(Subject a, Subject b){
        return a.starttime - b.starttime;
    }
}
