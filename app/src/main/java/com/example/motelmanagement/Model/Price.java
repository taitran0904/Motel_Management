package com.example.motelmanagement.Model;

public class Price {
    private int id;
    private int electric;
    private int water;
    private int idUser;

    public Price(int id, int electric, int water, int idUser) {
        this.id = id;
        this.electric = electric;
        this.water = water;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
