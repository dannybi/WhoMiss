package com.benishay.danny.whomiss.Data;

import java.util.HashMap;

/**
 * Created by Dan on 19/08/2017.
 */

public class MyTeachers {
    private String name, teachKey_email, phone;
    private HashMap<String, Object> groupKeys;
    private HashMap<String, Object> studKeys;

    public MyTeachers() {
        this.groupKeys = new HashMap<>();
        this.studKeys = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachKey_email() {
        return teachKey_email;
    }

    public void setTeachKey_email(String teachKey_email) {
        this.teachKey_email = teachKey_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, Object> getGroupKeys() {
        return groupKeys;
    }

    public void setGroupKeys(HashMap<String, Object> groupKeys) {
        this.groupKeys = groupKeys;
    }

    public HashMap<String, Object> getStudKeys() {
        return studKeys;
    }

    public void setStudKeys(HashMap<String, Object> studKeys) {
        this.studKeys = studKeys;
    }

    @Override
    public String toString() {
        return "MyTeachers{" +
                "name='" + name + '\'' +
                ", teachKey_email='" + teachKey_email + '\'' +
                ", phone='" + phone + '\'' +
                ", groupKeys=" + groupKeys +
                ", studKeys=" + studKeys +
                '}';
    }
}
