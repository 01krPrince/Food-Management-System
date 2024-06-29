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

    public String discontinue(String  restaurantChoice) {
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

    public void updateRestaurantName(String id1, String email , String newRestaurantName) {
        restaurantRepositoryImpl.updateRestaurantName(id1 , email ,newRestaurantName);
    }

    public void updateRestaurantAddress(String id1, String email, String newRestaurantAddress) {
        restaurantRepositoryImpl.updateRestaurantAddress(id1 , email , newRestaurantAddress);
    }

    public void updateRestaurantPhone(String id1, String email, String newRestaurantPhone) {
        restaurantRepositoryImpl.updateRestaurantPhone(id1 , email , newRestaurantPhone);
    }
}
