package Controller;

import Service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderController {
    OrderService orderService = new OrderService();
    FoodItemController foodItemController = new FoodItemController();

    public void placeOrder(String restaurantId, String itemId, String itemName , String username, String address , String email) {
        int price = foodItemController.getPrice(itemName , itemId);
        orderService.placeOrder(restaurantId , itemId , itemName , username , address , email , price);
    }

    public Map<String , String > getOrderHistory(String username, String email) {
        return orderService.getOrderHistory(username , email);
    }

    public List<String> orderHistoryDetails(String orderItem, String orderId) {
        return orderService.orderHistoryDetails(orderItem , orderId);
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        return orderService.checkingOrderRequest(restaurantId);
    }

    public String deleverOrder(String orderId) {
        return orderService.deleverOrder(orderId);
    }
}
