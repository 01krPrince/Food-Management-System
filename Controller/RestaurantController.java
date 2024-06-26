package Controller;

import Service.Impl.RestaurantServiceImpl;

import java.util.Map;

public class RestaurantController {
    RestaurantServiceImpl restaurantServiceImpl = new RestaurantServiceImpl();

    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        return restaurantServiceImpl.registerRestaurant(email , restaurantName , location , phone);
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantServiceImpl.getRestaurantListOf(email);
    }

    public String discontinue(String restaurantChoice) {
        return restaurantServiceImpl.discontinue(restaurantChoice);
    }

    public int isRestaurantExist(String restaurantName, String email) {
        return restaurantServiceImpl.isRestaurantExist(restaurantName , email);
    }

    public boolean isphoneExist(String phone) {
        return restaurantServiceImpl.isPhoneExist(phone);
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

    public void updateRestaurantName(String id1, String email , String newRestaurantName) {
        restaurantServiceImpl.updateRestaurantName(id1 , email , newRestaurantName);
    }

    public void updateRestaurantAddress(String id1, String email, String newRestaurantAddress) {
        restaurantServiceImpl.updateRestaurantAddress(id1 , email , newRestaurantAddress);
    }

    public void updateRestaurantPhone(String id1, String email, String newRestaurantPhone) {
        restaurantServiceImpl.updateRestaurantPhone(id1 , email , newRestaurantPhone);
    }
}
