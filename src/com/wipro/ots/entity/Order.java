package com.wipro.ots.entity;

public class Order {

    private String orderId;
    private String userId;
    private String status;

    public Order(String orderId, String userId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
