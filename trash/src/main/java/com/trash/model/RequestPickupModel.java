package com.trash.model;

import java.util.Date;


public class RequestPickupModel {
    private int id;
    private int wasteId;  // Menyimpan ID sampah
    private String wasteDescription;
    private Date pickupDate;
    private String status;
    private double weight;  // Berat sampah
    private String address; // Alamat penjemputan

    // Constructor yang sudah diperbarui
    public RequestPickupModel(int id, String wasteDescription, Date pickupDate, String status, double weight, String address) {
        this.id = id;
        this.wasteId = wasteId;
        this.wasteDescription = wasteDescription;
        this.pickupDate = pickupDate;
        this.status = status;
        this.weight = weight;
        this.address = address;
    }

    // Getters dan Setters
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

    public String getWasteDescription() {
        return wasteDescription;
    }

    public void setWasteDescription(String wasteDescription) {
        this.wasteDescription = wasteDescription;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


