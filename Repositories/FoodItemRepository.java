package Repositories;

import model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItemRepository {
    List<FoodItem> foodItemsList = new ArrayList<>();
    static int foodItemId = 1;

    public void addItem(String item, String restaurantName, String restaurantId, int price) {
        foodItemId = foodItemsList.size() + 1;
        FoodItem foodItem = new FoodItem(item, foodItemId, restaurantName, restaurantId, price);
        foodItemsList.add(foodItem);
    }

    public Map<String, String> getRestaurantMenuOf(String restaurantName) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem item : foodItemsList) {
            if (item.getStatus() != null && item.getRestaurantname() != null &&
                    item.getStatus().equals("available") && item.getRestaurantname().equals(restaurantName)) {
                menuOf.put(item.getItem(), String.valueOf(item.getFoodItemsId()));
            }
        }
        return menuOf;
    }

    public void removeItem(String restaurantId, String foodItemId) {
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getRestaurantId() != null && String.valueOf(foodItem.getFoodItemsId()) != null &&
                    foodItem.getRestaurantId().equals(restaurantId) && String.valueOf(foodItem.getFoodItemsId()).equals(foodItemId)) {
                foodItem.setStatus("unavailable");
            }
        }
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        Map<String, String> menuOf = new HashMap<>();
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getStatus() != null && foodItem.getRestaurantId() != null &&
                    foodItem.getStatus().equals("available") && foodItem.getRestaurantId().equals(restaurantId)) {
                menuOf.put(foodItem.getItem(), String.valueOf(foodItem.getFoodItemsId()));
            }
        }
        return menuOf;
    }

    public String getItemNameById(String itemId) {
        for (FoodItem foodItem : foodItemsList) {
            if (String.valueOf(foodItem.getFoodItemsId()) != null &&
                    String.valueOf(foodItem.getFoodItemsId()).equals(itemId)) {
                return foodItem.getItem();
            }
        }
        return "null";
    }

    public int getPrice(String menuItem, String menuId) {
        for (FoodItem foodItem : foodItemsList) {
            if (foodItem.getItem() != null && String.valueOf(foodItem.getFoodItemsId()) != null &&
                    foodItem.getItem().equals(menuItem) && String.valueOf(foodItem.getFoodItemsId()).equals(menuId) &&
                    foodItem.getStatus().equals("available")) {
                return foodItem.getPrice();
            }
        }
        return 0;
    }
}
