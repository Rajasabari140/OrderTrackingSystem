package com.wipro.ots.main;

import java.util.ArrayList;

import com.wipro.ots.entity.Order;
import com.wipro.ots.entity.TrackingUpdate;
import com.wipro.ots.service.OrderTrackingService;
import com.wipro.ots.util.OrderNotFoundException;
import com.wipro.ots.util.TrackingOperationException;

public class Main {
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<TrackingUpdate> updates = new ArrayList<>();

        OrderTrackingService service = new OrderTrackingService(orders, updates);

        try {
            Order o1 = new Order("O001", "U001", "PLACED");
            service.placeOrder(o1);

            service.addTrackingUpdate("O001", "2025-05-01", "Order Packed");
            service.addTrackingUpdate("O001", "2025-05-02", "Shipped from Warehouse");
            service.addTrackingUpdate("O001", "2025-05-03", "Reached Local Hub");
            service.addTrackingUpdate("O001", "2025-05-04", "Out For Delivery");

            service.updateOrderStatus("O001", "DELIVERED");

            System.out.println("\n--- Tracking History ---");
            for (TrackingUpdate t : service.getTrackingHistory("O001")) {
                System.out.println(t.getNotes());
            }

            System.out.println("\n--- All Orders ---");
            service.displayAllOrders();

            System.out.println("\n--- Cancelling Order ---");
            service.cancelOrder("O001");

        } catch (OrderNotFoundException | TrackingOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
