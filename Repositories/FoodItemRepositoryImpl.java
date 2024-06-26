package Repositories;

import model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItemRepositoryImpl {
    List<FoodItem> foodItemsList = new ArrayList<>();
    static int foodItemId = 1;

    public void addItem(String foodItemName, String restaurantName, String restaurantId, int price) {
        foodItemId = foodItemsList.size() + 1;
        FoodItem foodItem = new FoodItem(foodItemName, foodItemId, restaurantName, restaurantId, price);
        foodItemsList.add(foodItem);
    }

    public Map<String, String> getRestaurantMenuOf(String restaurantName) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem item : foodItemsList) {
            if (item.getRestaurantname().equals(restaurantName)  &&  item.getStatus().equals("available")){
                menuOf.put(item.getfoodItemName(), String.valueOf(item.getFoodItemsId()));
            }
        }
        return menuOf;
    }

    public void removeItem(String restaurantId, String foodItemId) {
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getRestaurantId().equals(restaurantId) &&
                    String.valueOf(foodItem.getFoodItemsId()).equals(foodItemId)) {
                foodItem.setStatus("unavailable");
            }
        }
    }


    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getStatus() != null && foodItem.getRestaurantId() != null &&
                    foodItem.getStatus().equals("available") && foodItem.getRestaurantId().equals(restaurantId)) {
                menuOf.put(foodItem.getfoodItemName(), String.valueOf(foodItem.getFoodItemsId()));
            }
        }
        return menuOf;
    }

    public String getItemNameById(String itemId) {
        for (FoodItem foodItem : foodItemsList) {
            if (String.valueOf(foodItem.getFoodItemsId()).equals(itemId)) {
                return foodItem.getfoodItemName();
            }
        }
        return null;
    }


    public int getPrice(String foodItemName, String foodId) {
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getfoodItemName().equals(foodItemName) &&
                    String.valueOf(foodItem.getFoodItemsId()).equals(foodId) &&
                    foodItem.getStatus().equals("available")) {
                return foodItem.getPrice();
            }
        }
        return 0;
    }

}