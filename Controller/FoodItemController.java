package Controller;

import Service.FoodItemService;
import model.FoodItem;

import java.util.List;
import java.util.Map;

public class FoodItemController {
    FoodItemService foodItemService = new FoodItemService();

    public void addItem(String item, String restaurantName) {
        foodItemService.addItem( item,  restaurantName);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemService.getRestaurantMenuOf(restaurantName);
    }
}
