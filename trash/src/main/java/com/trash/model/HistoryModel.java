package com.trash.model;


public class HistoryModel {
    private int id;
    private int wasteId;          // ID sampah yang diminta untuk dijemput
    private String status;        // Status permintaan (misalnya: "Pending", "Completed")
    private String requestDate;   // Tanggal permintaan dibuat
    private String pickupDate;    // Tanggal penjemputan dilakukan (jika sudah selesai)
    private double weight;        // Berat sampah yang dijemput
    private String address;       // Alamat penjemputan


    public HistoryModel(int wasteId, String status, String requestDate, String pickupDate) {
        this.wasteId = wasteId;
        this.status = status;
        this.requestDate = requestDate;
        this.pickupDate = pickupDate;
        this.weight = weight;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWasteId() {
        return wasteId;
    }

    public void setWasteId(int wasteId) {
        this.wasteId = wasteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
