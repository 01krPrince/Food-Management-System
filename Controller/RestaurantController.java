package Controller;

import Service.RestaurantService;

import java.util.List;
import java.util.Map;

public class RestaurantController {
    RestaurantService restaurantService = new RestaurantService();

    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        return restaurantService.registerRestaurant(email , restaurantName , location , phone);
    }

    public List getRestaurantNameList(String email, String password) {
        return restaurantService.getRestaurantNameList(email , password);
    }

    public String getrestaurantNameByEamil(String email) {
        return restaurantService.getrestaurantNameByEamil(email);
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantService.getRestaurantListOf(email);
    }

    public String discontinue(int restaurantChoice) {
        return restaurantService.discontinue(restaurantChoice);
    }

    public int isRestaurantExist(String restaurantName, String email) {
        return restaurantService.isRestaurantExist(restaurantName , email);
    }

    public boolean isphoneExist(String phone) {
        return restaurantService.isphoneExist(phone);
    }

    public Map<String, String> getAllAvailableRestaurantList() {
        return restaurantService.getAllAvailableRestaurantList();
    }

    public String getRestaurantNameById(String restaurantId) {
        return restaurantService.getRestaurantNameById(restaurantId);
    }
}
