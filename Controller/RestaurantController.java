package Controller;

import Service.RestaurantServiceImpl;

import java.util.List;
import java.util.Map;

public class RestaurantController {
    RestaurantServiceImpl restaurantServiceImpl = new RestaurantServiceImpl();

    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        return restaurantServiceImpl.registerRestaurant(email , restaurantName , location , phone);
    }

    public List getRestaurantNameList(String email, String password) {
        return restaurantServiceImpl.getRestaurantNameList(email , password);
    }

    public String getrestaurantNameByEamil(String email) {
        return restaurantServiceImpl.getrestaurantNameByEamil(email);
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantServiceImpl.getRestaurantListOf(email);
    }

    public String discontinue(int restaurantChoice) {
        return restaurantServiceImpl.discontinue(restaurantChoice);
    }

    public int isRestaurantExist(String restaurantName, String email) {
        return restaurantServiceImpl.isRestaurantExist(restaurantName , email);
    }

    public boolean isphoneExist(String phone) {
        return restaurantServiceImpl.isphoneExist(phone);
    }

    public Map<String, String> getAllAvailableRestaurantList() {
        return restaurantServiceImpl.getAllAvailableRestaurantList();
    }

    public String getRestaurantNameById(String restaurantId) {
        return restaurantServiceImpl.getRestaurantNameById(restaurantId);
    }

    public int isValidRestaurantId(String username, String email, String restaurantId) {
        return restaurantServiceImpl.isValidRestaurantId(username , email , restaurantId);
    }
}
