package Service;

import Repositories.FoodItemRepository;
import model.FoodItem;

import java.util.List;
import java.util.Map;

public class FoodItemService {
    FoodItemRepository foodItemRepository = new FoodItemRepository();

    public void addItem(String item, String restaurantName) {
        foodItemRepository.addItem( item,  restaurantName);
    }

    public Map<String , String> getRestaurantMenuOf(String restaurantName) {
        return foodItemRepository.getRestaurantMenuOf(restaurantName);
    }

    public void removeItem(int itemIDToRemove) {
        foodItemRepository.removeItem(itemIDToRemove);
    }
}
