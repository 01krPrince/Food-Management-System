package Repositories.Impl;

import Repositories.FoodItemRepository;
import Model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItemRepositoryImpl implements FoodItemRepository {
    List<FoodItem> foodItemsList = new ArrayList<>();

    public void addItem(FoodItem foodItem) {
        foodItemsList.add(foodItem);
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
                menuOf.put(String.valueOf(foodItem.getFoodItemsId()) , foodItem.getfoodItemName());
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

    public void updateItemPrice(String id1, String id2 , String newPrice) {
        for (FoodItem foodItem : foodItemsList){
            if (foodItem.getRestaurantId().equals(id1)  &&  String.valueOf(foodItem.getFoodItemsId()).equals(id2)){
                foodItem.setPrice(Integer.valueOf(newPrice));
            }
        }
    }

    public boolean getItemExistanceStatus(String itemToAdd) {
        for (FoodItem foodItem : foodItemsList){
            if (foodItem.getfoodItemName().equals(itemToAdd)){
                return true;
            }
        }
        return false;
    }

    public int getNumberOfItem() {
        int i = 0;
        for (FoodItem foodItem : foodItemsList){
            ++i;
        }
        return i;
    }
}