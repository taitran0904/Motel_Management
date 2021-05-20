package com.example.motelmanagement.Model;

public class Renter {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private String cmnd;
    private String phone;
    private String dayOfHide;
    private int idRoom;
    private int idUser;

    public Renter(int id, String name, String sex, String birthday, String cmnd, String phone, String dayOfHide, int idRoom, int idUser) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.phone = phone;
        this.dayOfHide = dayOfHide;
        this.idRoom = idRoom;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDayOfHide() {
        return dayOfHide;
    }

    public void setDayOfHide(String dayOfHide) {
        this.dayOfHide = dayOfHide;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
