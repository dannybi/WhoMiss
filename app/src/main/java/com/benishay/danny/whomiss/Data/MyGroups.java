package com.benishay.danny.whomiss.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Dan on 19/08/2017.
 */

public class MyGroups implements Serializable {
    private String gKey;
    private String name;
    private String schoolName;
    private String mngrStudKey;
    private String grader;
    private HashMap<String, Object> studentKeys;
    private HashMap<String, Object> teacherKeys;

    public MyGroups() {

        this.studentKeys = new HashMap<>();
        this.teacherKeys = new HashMap<>();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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

    public String getGrader() {
        return grader;
    }

    public void setGrader(String grader) {
        this.grader = grader;
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
