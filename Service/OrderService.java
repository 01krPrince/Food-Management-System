package Service;

import Repositories.OrderRepository;

import java.util.List;
import java.util.Map;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public void placeOrder(String restaurantId, String itemId,String itemName ,String username, String address , String email , int price) {
        orderRepository.placeOrder(restaurantId , itemId ,itemName, username , address , email , price);
    }

    public Map<String, String> getOrderHistory(String username, String email) {
        return orderRepository.getOrderHistory(username , email);
    }

    public List<String> orderHistoryDetails(String orderItem, String orderId) {
        return orderRepository.orderHistoryDetails(orderItem , orderId);
    }

    public List<String> checkingOrderRequest(String restaurantId) {
        return orderRepository.checkingOrderRequest(restaurantId);
    }

    public String deleverOrder(String orderId) {
        return orderRepository.deleverOrder(orderId);
    }
}
