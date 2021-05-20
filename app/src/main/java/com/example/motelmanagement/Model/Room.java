package com.example.motelmanagement.Model;

public class Room {
    private int id;
    private String roomName;
    private String deposit;
    private int electricNum;
    private int waterNum;
    private String status;
    private int idUser;

    public Room(int id, String roomName, String deposit, int electricNum, int waterNum, String status, int idUser) {
        this.id = id;
        this.roomName = roomName;
        this.deposit = deposit;
        this.electricNum = electricNum;
        this.waterNum = waterNum;
        this.status = status;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getElectricNum() {
        return electricNum;
    }

    public void setElectricNum(int electricNum) {
        this.electricNum = electricNum;
    }

    public int getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(int waterNum) {
        this.waterNum = waterNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
