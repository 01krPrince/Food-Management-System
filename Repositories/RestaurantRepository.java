package Repositories;

import model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepository {
    List<Restaurant> restaurantList = new ArrayList<>();
    static int restaurantsId = 100;

    public int registerRestaurant(String email, String restaurantName, String location , String phone) {
        restaurantsId = restaurantsId + ((restaurantList.size()) * 5);
        Restaurant restaurant = new Restaurant(restaurantName , location , phone , email , restaurantsId);
        restaurantList.add(restaurant);
        return restaurantsId;
    }

    public List getRestaurantNameList(String email, String password) {
        List<String> restaurants = new ArrayList<>();
        for (Restaurant i : restaurantList){
            if (i.getEmail().equals(email)){
                restaurants.add(i.getRestautantName());
                restaurants.add(String.valueOf(restaurantsId));
            }
        }
        return restaurantList;
    }

    public String getRestaurantNameByEamil(String email) {
        for (Restaurant restaurant : restaurantList){
            if (restaurant.getEmail().equals(email)){
                return restaurant.getEmail();
            }
        }
        return null;
    }

    public Map<String, String> getRestaurantListOf(String email) {
        Map<String, String> restaurantMap = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getEmail().equals(email)) {
                restaurantMap.put(restaurant.getRestautantName(), String.valueOf(restaurant.getRestaurantsId()));
            }
        }
        return restaurantMap;
    }

    public String discontinueRestaurant(int restaurantChoice) {
        int i = 0;
        for (Restaurant restaurant : restaurantList){
            ++i;
            if(i == restaurantChoice){
                if (restaurant.setStatus().equals("open")){
                    restaurant.setStatus("close");
                    return "discontinued";
                }
                else {
                    return "already discontinued";
                }
            }
        }
        return "null";
    }

}



















