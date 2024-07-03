package Controller;

import Model.FoodItem;
import Repositories.FoodItemRepository;
import Repositories.Impl.FoodItemRepositoryImpl;
import Service.Impl.FoodItemServiceImpl;
import Service.Impl.RestaurantServiceImpl;

import java.util.Map;

public class FoodItemController {
    FoodItemServiceImpl foodItemServiceImpl = new FoodItemServiceImpl();

    public void addItem(String itemToAdd, String restaurantId, int price) {
        foodItemServiceImpl.addItem(itemToAdd, restaurantId, price);
    }

    public void removeItem(String restaurantId, String foodId) {
        foodItemServiceImpl.removeItem(restaurantId , foodId);
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        return foodItemServiceImpl.getRestaurantMenuByRestaurantId(restaurantId);
    }

    public String  getItemNameById(String foodId) {
        return foodItemServiceImpl.getFoodItemNameById(foodId);
    }

    public int getPrice(String foodItemName, String  foodId) {
        return foodItemServiceImpl.getPrice(foodItemName , foodId);
    }

    public void updateItemPrice(String id1, String id2 , String newPrice) {
        foodItemServiceImpl.updateItemPrice(id1 , id2 , newPrice);
    }


    public boolean getItemExistanceStatus(String itemToAdd) {
        return foodItemServiceImpl.getItemExistanceStatus(itemToAdd);
    }
}
