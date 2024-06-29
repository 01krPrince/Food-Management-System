package Service.Impl;


import Repositories.Impl.FoodItemRepositoryImpl;
import Service.FoodItemService;

import java.util.Map;

public class FoodItemServiceImpl implements FoodItemService {
    FoodItemRepositoryImpl foodItemRepositoryImpl = new FoodItemRepositoryImpl();

    public void addItem(String item,String restaurantName, String restaurantId , int price) {
        foodItemRepositoryImpl.addItem( item,restaurantName,  restaurantId , price);
    }

    public void removeItem(String restaurantId, String foodItemId) {
        foodItemRepositoryImpl.removeItem(restaurantId , foodItemId);
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        return foodItemRepositoryImpl.getRestaurantMenuByRestaurantId(restaurantId);
    }

    public String getFoodItemNameById(String foodItemName) {
        return foodItemRepositoryImpl.getItemNameById(foodItemName);
    }

    public int getPrice(String foodItemName, String foodId) {
        return foodItemRepositoryImpl.getPrice(foodItemName , foodId);
    }

    public void updateItemPrice(String id1, String id2 , String newPrice) {
        foodItemRepositoryImpl.updateItemPrice(id1 , id2 , newPrice);
    }
}
