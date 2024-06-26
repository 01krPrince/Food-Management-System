package Repositories;

import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl {

    private static final List<Order> orderList = new ArrayList<>();
    static int orderID = 199;

    public void placeOrder(String restaurantId,String restaurantName , String itemId, String itemName , String username , String email , int price) {
        orderID = orderID + ((orderList.size()) * 37);
        Order order = new Order( username,  restaurantId,restaurantName,  itemId , itemName, email ,  orderID , price);
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

    public List<String> orderHistoryDetails(String orderItemName, String orderId) {
        List<String> orderHistoryInfo = new ArrayList<>();
        for (Order order : orderList){
            if (order.getItemName().equals(orderItemName)  &&  String.valueOf(order.getOrderID()).equals(orderId)){
                orderHistoryInfo.add(order.getRestaurantName());
                orderHistoryInfo.add(order.getOrderStatus());
            }
        }
        return orderHistoryInfo;
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        List<String> checkingOrderRequestList = new ArrayList<>();
        for (Order order : orderList){
            if (!order.getOrderStatus().equals("cancelled")  &&  !order.getOrderStatus().equals("delivered")  &&  String.valueOf(order.getRestaurantID()).equals(restaurantId)){
                checkingOrderRequestList.add(String.valueOf(order.getOrderID()));
            }
        }
        return checkingOrderRequestList;
    }

    public boolean deliverOrder(String orderId) {
        for (Order order : orderList){
            if (String.valueOf(order.getOrderID()).equals(orderId)){
                order.setOrderStatus("delivered");
                return true;
            }
        }
        return false;
    }

    public int getPriceByOrderId(String orderId) {
        for (Order order : orderList){
            if (String.valueOf(order.getOrderID()).equals(orderId)){
                return order.getPrice();
            }
        }
        return 0;
    }

    public String getFoodIdBy(String orderId) {
        for (Order order : orderList){
            if (String.valueOf(order.getOrderID()).equals(orderId)){
                return String.valueOf(order.getFoodID());
            }
        }
        return null;
    }
}
