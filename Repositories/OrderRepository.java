package Repositories;

import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private static List<Order> orderList = new ArrayList<>();
    static int orderID = 199;

    public void placeOrder(String restaurantId, String itemId, String itemName , String username, String address , String email , int price) {
        orderID = orderID + ((orderList.size()) * 37);
        Order order = new Order( username,  address,  restaurantId,  itemId , itemName, email ,  orderID , price);
        orderList.add(order);
    }


    public Map<String, String> getOrderHistory(String username, String email) {
        Map<String , String > orderHistory = new HashMap<>();
        for (Order order : orderList){
            if (order.getUsername().equals(username)  &&  order.getEmail().equals(email)){
                orderHistory.put(order.getItemName() , String.valueOf(order.getOrderID()));
            }
        }
        return orderHistory;
    }

    public List<String> orderHistoryDetails(String orderItem, String orderId) {
        List<String> orderHistoryInfo = new ArrayList<>();
        for (Order order : orderList){
            if (order.getItemName().equals(orderItem)  &&  String.valueOf(order.getOrderID()).equals(orderId)){
                orderHistoryInfo.add(String.valueOf(order.getPrice()));
                orderHistoryInfo.add(order.getOrderStatus());
            }
        }
        return null;
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        List<String> checkingOrderRequestList = new ArrayList<>();
        for (Order order : orderList){
            if (!order.getOrderStatus().equals("Cancelled")  &&  !order.getOrderStatus().equals("delivered")){
                checkingOrderRequestList.add(String.valueOf(order.getOrderID()));
            }
        }
        return checkingOrderRequestList;
    }

    public String deleverOrder(String orderId) {
        for (Order order : orderList){
            if (String.valueOf(order.getOrderID()).equals(orderId)){
                order.setOrderStatus("delivered");
                return "Order Delivered";
            }
        }
        return null;
    }
}
