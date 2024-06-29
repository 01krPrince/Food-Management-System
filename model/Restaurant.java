package model;

public class Restaurant {
    private String restaurantName;
    private String location;
    private String phone;
    private String email;
    private String status;
    private int restaurantId;

    public Restaurant(String restaurantName, String location, String phone, String email , int restaurantsId) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.status = "open";
        this.restaurantId = restaurantsId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public int getRestaurantsId() {
        return restaurantId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
