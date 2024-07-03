package Model;

public class Restaurant {
    private String restaurantName;
    private String restaurantAddress;
    private String phone;
    private String email;
    private String status;
    private String restaurantId;

    public Restaurant(String restaurantName, String restaurantAddress, String phone, String email , String restaurantsId) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
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

    public String getrestaurantAddress() {
        return restaurantAddress;
    }

    public void setrestaurantAddress(String location) {
        this.restaurantAddress = location;
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

    public String getRestaurantsId() {
        return restaurantId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}