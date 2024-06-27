package Repositories;

import java.util.List;
import java.util.Map;

public interface OrderRepository {
    void placeOrder(String restaurantId, String restaurantName, String itemId, String itemName, String username, String email, int price);
    Map<String, String> getOrderHistory(String username, String email);
    List<String> orderHistoryDetails(String orderItemName, String orderId);
    List<String> checkingOrderRequest(String restaurantId);
    boolean deliverOrder(String orderId);
    int getPriceByOrderId(String orderId);
    String getFoodIdBy(String orderId);
    Map<String, String> getPendingOrderList();
}
