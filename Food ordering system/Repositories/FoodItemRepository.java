package Repositories;

import Model.FoodItem;

import java.util.Map;

public interface FoodItemRepository {
    void addItem(FoodItem foodItem);
    void removeItem(String restaurantId, String foodItemId);
    Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId);
    String getItemNameById(String itemId);
    int getPrice(String foodItemName, String foodId);
}
