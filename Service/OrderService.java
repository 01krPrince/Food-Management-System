package Service;

import Repositories.OrderRepository;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public void placeOrder(String restaurantId, String itemId, String username, String address) {
        orderRepository.placeOrder(restaurantId , itemId , username , address);
    }
}
