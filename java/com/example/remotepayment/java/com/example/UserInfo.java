package com.example.liuji.nfcdemo;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private int ID;

    private String userName;

    private String idCard;

    private String phone;

    private String password;

    private int role;

    public UserInfo(int ID, String userName, String idCard, String phone, String password, int role) {
        this.ID = ID;
        this.userName = userName;
        this.idCard = idCard;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public UserInfo(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
