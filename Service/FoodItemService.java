package Service;

import java.util.Map;

public interface FoodItemService {

    void addItem(String item, String restaurantName, String restaurantId, int price);

    void removeItem(String restaurantId, String foodItemId);

    Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId);

    String getFoodItemNameById(String foodItemId);

    int getPrice(String foodItemName, String foodId);
}
