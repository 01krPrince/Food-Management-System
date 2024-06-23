package model;

public class Restaurant {
    private String restautantName;
    private String location;
    private String phone;
    private String email;
    private String status;
    private int restaurantsId;

    public Restaurant(String restautantName, String location, String phone, String email , int restaurantsId) {
        this.restautantName = restautantName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.status = "open";
        this.restaurantsId = restaurantsId;
    }

    public String getRestautantName() {
        return restautantName;
    }

    public void setRestautantName(String restautantName) {
        this.restautantName = restautantName;
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

    public void getStatus(String status) {
        this.status = status;
    }

    public int getRestaurantsId() {
        return restaurantsId;
    }

    public void setRestaurantsId(int restaurantsId) {
        this.restaurantsId = restaurantsId;
    }
}
