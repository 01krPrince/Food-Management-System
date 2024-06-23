package model;

public class Order {
    private String username;
    private String address;
    private String itemID;
    private String itemName;
    private String restaurantID;
    private int orderID;
    private String email;
    private int price;
    private String orderStatus = "Order Placed, Waiting for confirmation by restaurant...";

    public Order(String username, String address, String restaurantID, String itemID , String itemName , String email , int orderID , int price) {
        this.username = username;
        this.restaurantID = restaurantID;
        this.orderID = orderID;
        this.itemName = itemName;
        this.address = address;
        this.itemID = itemID;
        this.email = email;
        this.price = price;
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

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
