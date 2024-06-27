package Service;

import java.util.Map;

public interface RestaurantService {

    int registerRestaurant(String email, String restaurantName, String location, String phone);

    Map<String, String> getRestaurantListOf(String email);

    String discontinue(int restaurantChoice);

    int isRestaurantExist(String restaurantName, String email);

    boolean isPhoneExist(String phone);

    Map<String, String> getAllAvailableRestaurantList();

    String getRestaurantNameById(String restaurantId);

    int isValidRestaurantId(String username, String email, String restaurantId);
}
