package Repositories;

import java.util.Map;

public interface FoodItemRepository {
    void addItem(String foodItemName, String restaurantName, String restaurantId, int price);
    void removeItem(String restaurantId, String foodItemId);
    Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId);
    String getItemNameById(String itemId);
    int getPrice(String foodItemName, String foodId);
}
