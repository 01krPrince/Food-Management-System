package Service;

import java.util.List;
import java.util.Map;

public interface OrderService {

    void placeOrder(String restaurantId, String restaurantName, String foodItemId, String foodItemName, String username, String email, int price);

    Map<String, String> getOrderHistory(String username, String email);

    List<String> orderHistoryDetails(String orderItemName, String orderId);

    List<String> checkingOrderRequest(String restaurantId);

    boolean deliverOrder(String orderId);

    int getPriceByOrderId(String orderId);

    String getFoodIdBy(String orderId);

    Map<String, String> getPendingOrderList(String username , String email);
}
