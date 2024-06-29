package Controller;

import Service.Impl.FoodItemServiceImpl;

import java.util.Map;

public class FoodItemController {
    FoodItemServiceImpl foodItemServiceImpl = new FoodItemServiceImpl();
    RestaurantController restaurantController = new RestaurantController();

    public void addItem(String food, String restaurantId , int price) {
        String restorentName = restaurantController.getRestaurantNameById(restaurantId);
        foodItemServiceImpl.addItem( food,restorentName, restaurantId, price);
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
}
