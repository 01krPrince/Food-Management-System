package Repositories;

import model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItemRepository {
    List<FoodItem> foodItemsList = new ArrayList<>();
    static int foodItemId = 1;

    public void addItem(String item, String restaurantName) {
        foodItemId = foodItemsList.size() + 1;
        FoodItem foodItem = new FoodItem(restaurantName , item , foodItemId);
        foodItemsList.add(foodItem);
    }


    public Map<String, String> getRestaurantMenuOf(String restaurantName) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem item : foodItemsList) {
            if (item.getStatus().equals("available")  &&  item.getRestaurantname().equals(restaurantName)) {
                menuOf.put(item.getItem(), String.valueOf(item.getFoodItemsId()));
            }
        }
        return menuOf;
    }


    public void removeItem(int itemIDToRemove) {
        for (FoodItem foodItem : foodItemsList){
            if (foodItem.getFoodItemsId() == itemIDToRemove){
                foodItem.setStatus();
            }
        }
    }
}
