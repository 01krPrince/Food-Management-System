package Controller;

import Service.OrderServiceImpl;

import java.util.List;
import java.util.Map;

public class OrderController {
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    FoodItemController foodItemController = new FoodItemController();

    public void placeOrder(String restaurantId, String restaurantName, String foodId, String foodItemName , String username , String email , int price) {
        orderServiceImpl.placeOrder(restaurantId , restaurantName , foodId , foodItemName , username  , email , price);
    }

    public Map<String , String > getOrderHistory(String username, String email) {
        return orderServiceImpl.getOrderHistory(username , email);
    }

    public List<String> orderHistoryDetails(String orderItemName, String orderId) {
        return orderServiceImpl.orderHistoryDetails(orderItemName , orderId);
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        return orderServiceImpl.checkingOrderRequest(restaurantId);
    }

    public boolean deliverOrder(String orderId) {
        return orderServiceImpl.deliverOrder(orderId);
    }



    public String getFoodIdBy(String orderId) {
        return orderServiceImpl.getFoodIdBy(orderId);
    }
}
