package model;

public class Order {
    public String username;
    public String address;
    public String itemID;
    public String restaurantID;
    public int orderID;

    public Order(String username, String address, String restaurantID, String itemID , int orderID) {
        this.username = username;
        this.restaurantID = restaurantID;
        this.orderID = orderID;
        this.address = address;
        this.itemID = itemID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
