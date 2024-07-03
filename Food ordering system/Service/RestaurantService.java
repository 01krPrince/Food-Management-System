package Service;

import java.util.Map;

public interface RestaurantService {

    String registerRestaurant(String email, String restaurantName, String location , String phone);

    Map<String, String> getRestaurantListOf(String email);

    String discontinueRestaurant(String restaurantChoice);

    int isRestaurantExist(String restaurantName, String email);

    boolean isPhoneExist(String phone);

    Map<String, String> getAllAvailableRestaurantList();

    String getRestaurantNameById(String restaurantId);

    int isValidRestaurantId(String username, String email, String restaurantId);
}
