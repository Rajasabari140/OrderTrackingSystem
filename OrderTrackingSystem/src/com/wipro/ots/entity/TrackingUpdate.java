package com.wipro.ots.entity;

public class TrackingUpdate {
    private String updateId;
    private String orderId;
    private String date;
    private String notes;

    public TrackingUpdate(String updateId, String orderId, String date, String notes) {
        this.updateId = updateId;
        this.orderId = orderId;
        this.date = date;
        this.notes = notes;
    }

    // Getters
    public String getUpdateId() {
        return updateId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return date + " - " + notes + " (UpdateID: " + updateId + ")";
    }
}
