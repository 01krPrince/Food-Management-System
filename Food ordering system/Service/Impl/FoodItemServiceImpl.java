package Service.Impl;


import Repositories.Impl.FoodItemRepositoryImpl;
import Service.FoodItemService;
import Model.FoodItem;

import java.util.Map;

public class FoodItemServiceImpl implements FoodItemService {
    FoodItemRepositoryImpl foodItemRepositoryImpl = new FoodItemRepositoryImpl();
    RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();


    @Override
    public void addItem( String itemToAdd, String restaurantId, int price) {
        int Id = (foodItemRepositoryImpl.getNumberOfItem()+1);
        String itemId = String.valueOf(Id);
        String restaurantName = restaurantService.getRestaurantNameById(restaurantId);
        FoodItem foodItem = new FoodItem(itemId , itemToAdd , restaurantName , restaurantId , price);
        foodItemRepositoryImpl.addItem(foodItem);
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

    @Override
    public boolean getItemExistanceStatus(String itemToAdd) {
        return foodItemRepositoryImpl.getItemExistanceStatus(itemToAdd);
    }

    public void updateItemPrice(String id1, String id2 , String newPrice) {
        foodItemRepositoryImpl.updateItemPrice(id1 , id2 , newPrice);
    }

}
