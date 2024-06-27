package Service.Impl;


import Repositories.Impl.RestaurantRepositoryImpl;
import Service.RestaurantService;

import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepositoryImpl restaurantRepositoryImpl = new RestaurantRepositoryImpl();


    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        return restaurantRepositoryImpl.registerRestaurant(email , restaurantName , location , phone);
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantRepositoryImpl.getRestaurantListOf(email);
    }

    public String discontinue(int restaurantChoice) {
        return restaurantRepositoryImpl.discontinueRestaurant(restaurantChoice);
    }

    public int isRestaurantExist(String restaurantName, String email) {
        return restaurantRepositoryImpl.isRestaurantExist(restaurantName , email);
    }

    public boolean isPhoneExist(String phone) {
        return restaurantRepositoryImpl.isPhoneExist(phone);
    }

    public Map<String, String> getAllAvailableRestaurantList() {
        return restaurantRepositoryImpl.getAllAvailableRestaurantList();
    }

    public String getRestaurantNameById(String restaurantId) {
        return restaurantRepositoryImpl.getRestaurantNameById(restaurantId);
    }

    public int isValidRestaurantId(String username, String email, String restaurantId) {
        return restaurantRepositoryImpl.isValidRestaurantId(username , email , restaurantId);
    }
}
