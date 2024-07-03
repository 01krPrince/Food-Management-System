package Repositories;

import Model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantRepository {

    void registerRestaurant(Restaurant restaurant);
    List<String> getRestaurantNameList(String email, String password);
//    String getRestaurantNameByEmail(String email);
    Map<String, String> getRestaurantListOf(String email);
    String discontinueRestaurant(String restaurantChoice);
    int isRestaurantExist(String restaurantName, String email);
    boolean isPhoneExist(String phone);
    Map<String, String> getAllAvailableRestaurantList();
    String getRestaurantNameById(String restaurantId);
    int isValidRestaurantId(String username, String email, String restaurantId);

    int getNoOfRestaurant();
}
