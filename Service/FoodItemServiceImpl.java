package Service;


import Repositories.FoodItemRepositoryImpl;

import java.util.Map;

public class FoodItemServiceImpl {
    FoodItemRepositoryImpl foodItemRepositoryImpl = new FoodItemRepositoryImpl();

    public void addItem(String item,String restaurantName, String restaurantId , int price) {
        foodItemRepositoryImpl.addItem( item,restaurantName,  restaurantId , price);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemRepositoryImpl.getRestaurantMenuOf(restaurantName);
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
}
