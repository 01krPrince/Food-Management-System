package Service.Impl;

import Repositories.Impl.OrderRepositoryImpl;
import Service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderRepositoryImpl orderRepositoryImpl = new OrderRepositoryImpl();

    public void placeOrder(String restaurantId, String restaurantName , String foodItemId,String foodtemName ,String username , String email , int price) {
        orderRepositoryImpl.placeOrder(restaurantId , restaurantName , foodItemId ,foodtemName, username  , email , price);
    }

    public Map<String, String> getOrderHistory(String username, String email) {
        return orderRepositoryImpl.getOrderHistory(username , email);
    }

    public List<String> orderHistoryDetails(String orderItemName, String orderId) {
        return orderRepositoryImpl.orderHistoryDetails(orderItemName , orderId);
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        return orderRepositoryImpl.checkingOrderRequest(restaurantId);
    }

    public boolean deliverOrder(String orderId) {
        return orderRepositoryImpl.deliverOrder(orderId);
    }

    public int getPriceByOrderId(String orderId) {
        return orderRepositoryImpl.getPriceByOrderId(orderId);
    }

    public String getFoodIdBy(String orderId) {
        return orderRepositoryImpl.getFoodIdBy(orderId);
    }

    public Map<String, String> getPendingOrderList(String username , String email) {
        return orderRepositoryImpl.getPendingOrderList(username , email);
    }

    public void cancelOrder(String orderIdToCancel) {
        orderRepositoryImpl.cancelOrder(orderIdToCancel);
    }

    public String getFoodItemName(String foodId, String orderId) {
        return orderRepositoryImpl.getFoodItemName(foodId , orderId);
    }
}
