package Controller;

import Service.FoodItemServiceImpl;

import java.util.Map;

public class FoodItemController {
    FoodItemServiceImpl foodItemServiceImpl = new FoodItemServiceImpl();
    RestaurantController restaurantController = new RestaurantController();
//    OrderController orderController = new OrderController();

    public void addItem(String food, String restaurantId , int price) {
        String restorentName = restaurantController.getRestaurantNameById(restaurantId);
        foodItemServiceImpl.addItem( food,restorentName, restaurantId, price);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemServiceImpl.getRestaurantMenuOf(restaurantName);
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
}
