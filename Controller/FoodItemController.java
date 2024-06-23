package Controller;

import Service.FoodItemService;
import model.FoodItem;

import java.util.List;
import java.util.Map;

public class FoodItemController {
    FoodItemService foodItemService = new FoodItemService();
    RestaurantController restaurantController = new RestaurantController();

    public void addItem(String item, String restaurantId , int price) {
        String restorentName = restaurantController.getRestaurantNameById(restaurantId);
        foodItemService.addItem( item,restorentName, restaurantId, price);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemService.getRestaurantMenuOf(restaurantName);
    }


    public void removeItem(String restaurantId, String foodItemId) {
        foodItemService.removeItem(restaurantId , foodItemId);
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        return foodItemService.getRestaurantMenuByRestaurantId(restaurantId);
    }

    public String  getItemNameById(String itemId) {
        return foodItemService.getItemNameById(itemId);
    }

    public int getPrice(String menuItem, String menuId) {
        return foodItemService.getPrice(menuItem , menuId);
    }
}
