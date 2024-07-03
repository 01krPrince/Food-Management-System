package Service.Impl;


import Model.Restaurant;
import Repositories.Impl.RestaurantRepositoryImpl;
import Service.RestaurantService;

import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepositoryImpl restaurantRepositoryImpl = new RestaurantRepositoryImpl();


    public String registerRestaurant(String email, String restaurantName, String restaurantAddress , String phone) {
        int ID = 100 + (restaurantRepositoryImpl.getNoOfRestaurant() * 5);
        String restaurantId = String.valueOf(ID);
        Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress, phone, email , restaurantId);
        restaurantRepositoryImpl.registerRestaurant(restaurant);
        return restaurantId;
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantRepositoryImpl.getRestaurantListOf(email);
    }

    public String discontinueRestaurant(String  restaurantChoice) {
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

    public String getRestaurentAddressByName(String restaurantName) {
        return restaurantRepositoryImpl.getRestaurentAddressByName(restaurantName);
    }

    public String getPhonenumberByResId(String resId) {
        return restaurantRepositoryImpl.phonenumberByResId(resId);
    }
}
