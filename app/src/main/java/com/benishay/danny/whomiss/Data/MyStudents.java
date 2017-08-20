package com.benishay.danny.whomiss.Data;

import java.util.HashMap;

/**
 * Created by Dan on 19/08/2017.
 */

public class MyStudents {
    private String name, studKey_email, parentPhone;
    private HashMap<String, Object> groupKeys;
    private HashMap<String, Object> teacherKeys;

    public MyStudents() {
        this.groupKeys = new HashMap<>();
        this.teacherKeys = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudKey_email() {
        return studKey_email;
    }

    public void setStudKey_email(String studKey_email) {
        this.studKey_email = studKey_email;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public HashMap<String, Object> getGroupKeys() {
        return groupKeys;
    }

    public void setGroupKeys(HashMap<String, Object> groupKeys) {
        this.groupKeys = groupKeys;
    }

    public HashMap<String, Object> getTeacherKeys() {
        return teacherKeys;
    }

    public void setTeacherKeys(HashMap<String, Object> teacherKeys) {
        this.teacherKeys = teacherKeys;
    }

    @Override
    public String toString() {
        return "MyStudents{" +
                "name='" + name + '\'' +
                ", studKey_email='" + studKey_email + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                ", groupKeys=" + groupKeys +
                ", teachKeys=" + teacherKeys +
                '}';
    }
}
