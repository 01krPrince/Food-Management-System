package Service;

import Repositories.RestaurantRepository;

import java.util.List;
import java.util.Map;

public class RestaurantService {
    RestaurantRepository restaurantRepository = new RestaurantRepository();

    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        return restaurantRepository.registerRestaurant(email , restaurantName , location , phone);
    }

    public List getRestaurantNameList(String email, String password) {
        return restaurantRepository.getRestaurantNameList(email , password);
    }

    public String getrestaurantNameByEamil(String email) {
        return restaurantRepository.getRestaurantNameByEamil(email);
    }

    public Map<String, String> getRestaurantListOf(String email) {
        return restaurantRepository.getRestaurantListOf(email);
    }

    public String discontinue(int restaurantChoice) {
        return restaurantRepository.discontinueRestaurant(restaurantChoice);
    }

}
