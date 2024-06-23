package Service;

import Repositories.FoodItemRepository;
import model.FoodItem;

import java.util.List;
import java.util.Map;

public class FoodItemService {
    FoodItemRepository foodItemRepository = new FoodItemRepository();

    public void addItem(String item,String restorentName, String restaurantId , int price) {
        foodItemRepository.addItem( item,restorentName,  restaurantId , price);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemRepository.getRestaurantMenuOf(restaurantName);
    }

    public void removeItem(String restaurantId, String foodItemId) {
        foodItemRepository.removeItem(restaurantId , foodItemId);
    }

    public Map<String, String> getRestaurantMenuByRestaurantId(String restaurantId) {
        return foodItemRepository.getRestaurantMenuByRestaurantId(restaurantId);
    }

    public String getItemNameById(String itemId) {
        return foodItemRepository.getItemNameById(itemId);
    }

    public int getPrice(String menuItem, String menuId) {
        return foodItemRepository.getPrice(menuItem , menuId);
    }
}
