package Repositories.Impl;

import Repositories.RestaurantRepository;
import model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    List<Restaurant> restaurantList = new ArrayList<>();
    static int restaurantsId = 100;

    @Override
    public int registerRestaurant(String email, String restaurantName, String location, String phone) {
        restaurantsId = restaurantsId + ((restaurantList.size()) * 5);
        Restaurant restaurant = new Restaurant(restaurantName, location, phone, email, restaurantsId);
        restaurantList.add(restaurant);
        return restaurantsId;
    }

    @Override
    public List<String> getRestaurantNameList(String email, String password) {
        List<String> restaurants = new ArrayList<>();
        for (Restaurant i : restaurantList) {
            if (i.getEmail().equals(email)) {
                restaurants.add(i.getRestautantName());
                restaurants.add(String.valueOf(restaurantsId));
            }
        }
        return restaurants;
    }

//    @Override
//    public String getRestaurantNameByEmail(String email) {
//        for (Restaurant restaurant : restaurantList) {
//            if (restaurant.getEmail().equals(email)) {
//                return restaurant.getEmail();
//            }
//        }
//        return null;
//    }

    @Override
    public Map<String, String> getRestaurantListOf(String email) {
        Map<String, String> restaurantMap = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getEmail().equals(email)) {
                restaurantMap.put(String.valueOf(restaurant.getRestaurantsId()), restaurant.getRestautantName());
            }
        }
        return restaurantMap;
    }

    @Override
    public String discontinueRestaurant(int restaurantChoice) {
        int i = 0;
        for (Restaurant restaurant : restaurantList) {
            ++i;
            if (i == restaurantChoice) {
                if (restaurant.getStatus().equals("open")) {
                    restaurant.setStatus("close");
                    return "discontinued";
                } else {
                    return "already discontinued";
                }
            }
        }
        return "null";
    }

    @Override
    public int isRestaurantExist(String restaurantName, String email) {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getRestautantName().equals(restaurantName)) {
                if (restaurant.getEmail().equals(email)) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean isPhoneExist(String phone) {
        for (Restaurant restaurantOwner : restaurantList) {
            if (restaurantOwner.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, String> getAllAvailableRestaurantList() {
        Map<String, String> restaurantMap = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getStatus().equals("open")) {
                restaurantMap.put(restaurant.getRestautantName(), String.valueOf(restaurant.getRestaurantsId()));
            }
        }
        return restaurantMap;
    }

    @Override
    public String getRestaurantNameById(String restaurantId) {
        for (Restaurant restaurant : restaurantList) {
            if (String.valueOf(restaurant.getRestaurantsId()).equals(restaurantId)) {
                return restaurant.getRestautantName();
            }
        }
        return null;
    }

    @Override
    public int isValidRestaurantId(String username, String email, String restaurantId) {
        for (Restaurant restaurant : restaurantList) {
            if (String.valueOf(restaurant.getRestaurantsId()).equals(restaurantId)) {
                if (restaurant.getEmail().equals(email)) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }
}
