package com.benishay.danny.whomiss.Data;

import java.util.HashMap;

/**
 * Created by Dan on 19/08/2017.
 */

public class MyGroups {
    private String gKey, name, mngrStudKey;
    private HashMap<String, Object> studentKeys;
    private HashMap<String, Object> teacherKeys;


    public MyGroups() {

        this.studentKeys = new HashMap<>();
        this.teacherKeys = new HashMap<>();
    }

    public String getgKey() {

        return gKey;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public String getNamemngrStudKey() {
        return mngrStudKey;
    }

    public void setNamemngrStudKey(String ngrStudKey) {
        this.mngrStudKey = mngrStudKey;
    }

    public HashMap<String, Object> getStudentKeys() {
        return studentKeys;
    }

    public void setStudentKeys(HashMap<String, Object> studentKeys) {
        this.studentKeys = studentKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMngrStudKey() {
        return mngrStudKey;
    }

    public void setMngrStudKey(String mngrStudKey) {
        this.mngrStudKey = mngrStudKey;
    }

    public HashMap<String, Object> getTeacherKeys() {
        return teacherKeys;
    }

    public void setTeacherKeys(HashMap<String, Object> teacherKeys) {
        this.teacherKeys = teacherKeys;
    }

    @Override
    public String toString() {
        return "MyGroups{" +
                "gKey='" + gKey + '\'' +
                ", name='" + name + '\'' +
                ", namemngrStudKey='" + mngrStudKey + '\'' +
                ", studentKeys=" + studentKeys +
                ", teacherKeys=" + teacherKeys +
                '}';
    }
}
