package com.example.motelmanagement.Model;

public class Bill {
    private int id;
    private String roomCharge;
    private String electricMoney;
    private String waterMoney;
    private String internet;
    private String other;
    private String reason;
    private String invoiceDate;
    private String status;
    private int idRoom;
    private String total;
    private String electricNum;
    private String waterNum;
    private int idUser;

    public Bill(int id, String roomCharge, String electricMoney, String waterMoney, String internet, String other, String reason, String invoiceDate, String status, int idRoom, String total, String electricNum, String waterNum, int idUser) {
        this.id = id;
        this.roomCharge = roomCharge;
        this.electricMoney = electricMoney;
        this.waterMoney = waterMoney;
        this.internet = internet;
        this.other = other;
        this.reason = reason;
        this.invoiceDate = invoiceDate;
        this.status = status;
        this.idRoom = idRoom;
        this.total = total;
        this.electricNum = electricNum;
        this.waterNum = waterNum;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(String roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getElectricMoney() {
        return electricMoney;
    }

    public void setElectricMoney(String electricMoney) {
        this.electricMoney = electricMoney;
    }

    public String getWaterMoney() {
        return waterMoney;
    }

    public void setWaterMoney(String waterMoney) {
        this.waterMoney = waterMoney;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getElectricNum() {
        return electricNum;
    }

    public void setElectricNum(String electricNum) {
        this.electricNum = electricNum;
    }

    public String getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(String waterNum) {
        this.waterNum = waterNum;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
