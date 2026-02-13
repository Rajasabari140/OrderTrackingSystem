package com.wipro.ots.service;

import java.util.ArrayList;
import com.wipro.ots.entity.*;
import com.wipro.ots.exception.*;

public class OrderTrackingService {

    private ArrayList<Order> orders;
    private ArrayList<TrackingUpdate> updates;
    private int updateCounter = 1;

    public OrderTrackingService(ArrayList<Order> orders, ArrayList<TrackingUpdate> updates) {
        this.orders = orders;
        this.updates = updates;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully");
    }

    public Order findOrder(String orderId) throws OrderNotFoundException {
        for (Order o : orders) {
            if (o.getOrderId().equals(orderId)) {
                return o;
            }
        }
        throw new OrderNotFoundException("Order not found: " + orderId);
    }

    public void updateOrderStatus(String orderId, String newStatus)
            throws OrderNotFoundException {
        Order order = findOrder(orderId);
        order.setStatus(newStatus);
        System.out.println("Order status updated");
    }

    public void addTrackingUpdate(String orderId, String date, String notes)
            throws OrderNotFoundException, TrackingOperationException {

        if (notes == null || notes.trim().isEmpty()) {
            throw new TrackingOperationException("Tracking notes cannot be empty");
        }

        findOrder(orderId);

        String updateId = "T" + updateCounter++;
        updates.add(new TrackingUpdate(updateId, orderId, date, notes));
        System.out.println("Tracking update added");
    }

    public ArrayList<TrackingUpdate> getTrackingHistory(String orderId)
            throws OrderNotFoundException {

        findOrder(orderId);
        ArrayList<TrackingUpdate> history = new ArrayList<>();

        for (TrackingUpdate t : updates) {
            if (t.getOrderId().equals(orderId)) {
                history.add(t);
            }
        }
        return history;
    }

    public void cancelOrder(String orderId) throws OrderNotFoundException {
        findOrder(orderId);
        orders.removeIf(o -> o.getOrderId().equals(orderId));
        updates.removeIf(t -> t.getOrderId().equals(orderId));
        System.out.println("Order cancelled");
    }

    public void displayAllOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
