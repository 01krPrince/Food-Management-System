package Repositories;

import model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItemRepository {
    List<FoodItem> foodItemsList = new ArrayList<>();
    static int foodItemId = 1;

    public void addItem(String item , String restorentName , String restaurantId ) {
        foodItemId = foodItemsList.size() + 1;
        FoodItem foodItem = new FoodItem(item , foodItemId , restorentName , restaurantId);
        foodItemsList.add(foodItem);
    }


    public Map<String, String> getRestaurantMenuOf(String restaurantName) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem item : foodItemsList) {
            if (item.getStatus().equals("available") && item.getRestaurantname().equals(restaurantName)) {
                menuOf.put(item.getItem(), String.valueOf(item.getFoodItemsId()));
            }
        }
        return menuOf;
    }

    public void removeItem(String restaurantId, String foodItemId) {
        for (FoodItem foodItem : foodItemsList){
            if (foodItem.getRestaurantId().equals(restaurantId)  &&  String.valueOf(foodItem.getFoodItemsId()).equals(foodItemId)){
                foodItem.setStatus("unavailable");
            }
        }
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem foodItem : foodItemsList){
            if (foodItem.getStatus().equals("available")  &&  foodItem.getRestaurantId().equals(restaurantId)){
                menuOf.put(foodItem.getItem() , String.valueOf(foodItem.getFoodItemsId()));
            }
        }
        return menuOf;
    }
}
