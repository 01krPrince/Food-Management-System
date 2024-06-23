package Repositories;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static List<Order> orderList = new ArrayList<>();
    static int orderID = 199;

    public void placeOrder(String restaurantId, String itemId, String username, String address) {
        orderID = orderID + ((orderList.size()) * 37);
        Order order = new Order( username,  address,  restaurantId,  itemId ,  orderID);
        orderList.add(order);
    }


}
