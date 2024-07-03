package Repositories.Impl;

import Repositories.RestaurantRepository;
import Model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    @Override
    public List<String> getRestaurantNameList(String email, String password) {
        List<String> restaurants = new ArrayList<>();
        for (Restaurant i : restaurantList) {
            if (i.getEmail().equals(email)  &&  i.getStatus().equalsIgnoreCase("open")) {
                restaurants.add(i.getRestaurantName());
                restaurants.add(String.valueOf(i.getRestaurantsId()));
            }
        }
        return restaurants;
    }

    public int getNoOfRestaurant(){
        int i = 0;
        for (Restaurant restaurant : restaurantList){
            ++i;
        }
        return i;
    }

    @Override
    public Map<String, String> getRestaurantListOf(String email) {
        Map<String, String> restaurantMap = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getEmail().equals(email)  &&  restaurant.getStatus().equals("open")) {
                restaurantMap.put(String.valueOf(restaurant.getRestaurantsId()), restaurant.getRestaurantName());
            }
        }
        return restaurantMap;
    }

    @Override
    public String discontinueRestaurant(String restaurantChoice) {
        for (Restaurant restaurant : restaurantList) {
            if (String.valueOf(restaurant.getRestaurantsId()).equals(restaurantChoice)){
                if (restaurant.getStatus().equals("open")){
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

    @Override
    public int isRestaurantExist(String restaurantName, String email) {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getRestaurantName().equals(restaurantName)) {
                if (restaurant.getEmail().equals(email)) {
                    if (restaurant.getStatus().equals("open")){
                        return 3;
                    }
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
                restaurantMap.put(restaurant.getRestaurantName(), String.valueOf(restaurant.getRestaurantsId()));
            }
        }
        return restaurantMap;
    }

    @Override
    public String getRestaurantNameById(String restaurantId) {
        for (Restaurant restaurant : restaurantList) {
            if (String.valueOf(restaurant.getRestaurantsId()).equals(restaurantId)) {
                return restaurant.getRestaurantName();
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

    public void updateRestaurantName(String id1, String email , String newRestaurantName) {
        for (Restaurant restaurant : restaurantList){
            if (String.valueOf(restaurant.getRestaurantsId()).equals(id1)  &&  restaurant.getEmail().equals(email)){
                restaurant.setRestaurantName(newRestaurantName);
            }
        }
    }

    public void updateRestaurantAddress(String id1, String email, String newRestaurantAddress) {
        for (Restaurant restaurant : restaurantList){
            if (String.valueOf(restaurant.getRestaurantsId()).equals(id1)  &&  restaurant.getEmail().equals(email)){
                restaurant.setrestaurantAddress(newRestaurantAddress);
            }
        }
    }

    public void updateRestaurantPhone(String id1, String email, String newRestaurantPhone) {
        for (Restaurant restaurant : restaurantList){
            if (String.valueOf(restaurant.getRestaurantsId()).equals(id1)  &&  restaurant.getEmail().equals(email)){
                restaurant.setPhone(newRestaurantPhone);
            }
        }
    }

    public String getRestaurentAddressByName(String restaurantName) {
        for (Restaurant restaurant : restaurantList){
            if (restaurant.getRestaurantName().equals(restaurantName)){
                return restaurant.getrestaurantAddress();
            }
        }
        return null;
    }

    public String phonenumberByResId(String resId) {
        for (Restaurant restaurant : restaurantList){
            if (restaurant.getRestaurantsId().equals(resId)){
                return restaurant.getPhone();
            }
        }
        return null;
    }
}
