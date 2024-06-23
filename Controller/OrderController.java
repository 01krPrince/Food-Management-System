package Controller;

import Service.OrderService;

public class OrderController {
    OrderService orderService = new OrderService();

    public void placeOrder(String restaurantId, String itemId, String username, String address) {
        orderService.placeOrder(restaurantId , itemId , username , address);
    }
}
