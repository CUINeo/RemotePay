package com.example.liuji.nfcdemo;

import java.io.Serializable;

public class BindingInfo implements Serializable {

    private int pid;
    private String childName;
    private String childPhone;

    public BindingInfo(int pid, String childName, String childPhone) {
        this.pid = pid;
        this.childName = childName;
        this.childPhone = childPhone;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildPhone() {
        return childPhone;
    }

    public void setChildPhone(String childPhone) {
        this.childPhone = childPhone;
    }

    @Override
    public String toString() {
        return "BindingInfo{" +
                "pid=" + pid +
                ", childName" + childName +
                ", childPhone" + childPhone +
                '}';
    }
}
