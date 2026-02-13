package com.wipro.ots.main;
import java.util.ArrayList;
import com.wipro.ots.entity.*;
import com.wipro.ots.service.OrderTrackingService;
import com.wipro.ots.util.*;
public class Main {
 public static void main(String[] args) {
 ArrayList<Order> orders = new ArrayList<>();
 ArrayList<TrackingUpdate> updates = new ArrayList<>();
 OrderTrackingService service = new OrderTrackingService(orders, updates);
 try {
 // Placing new order
 Order o1 = new Order("O001", "U001", "PLACED");
 service.placeOrder(o1);
 // Adding tracking updates
 service.addTrackingUpdate("O001", "2025-05-01", "Order Packed");
 service.addTrackingUpdate("O001", "2025-05-02", "Shipped from Warehouse");
 service.addTrackingUpdate("O001", "2025-05-03", "Reached Local Hub");
 service.addTrackingUpdate("O001", "2025-05-04", "Out For Delivery");
 // Updating status
 service.updateOrderStatus("O001", "DELIVERED");
 // Display history
 System.out.println("--- Tracking History ---");
 for (TrackingUpdate t : service.getTrackingHistory("O001")) {
 System.out.println(t.getNotes());
 }
 // Display all orders
 System.out.println("--- All Orders ---");
 service.displayAllOrders();
 // Cancel order
 System.out.println("--- Cancelling Order ---");
 service.cancelOrder("O001");
 } catch (OrderNotFoundException | TrackingOperationException ex) {
 System.out.println(ex);
 }
 }
}