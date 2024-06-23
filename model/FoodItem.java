package model;

public class FoodItem {
    private String restaurantname;
    private String item;
    private int FoodItemsId;
    private String status;
    private String restaurantId;

    public FoodItem(String item, int foodItemId , String restaurantname , String restaurantId) {
        this.restaurantname = restaurantname;
        this.item = item;
        this.FoodItemsId = foodItemId;
        this.status = "available";
        this.restaurantId = restaurantId;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getFoodItemsId() {
        return FoodItemsId;
    }

    public void setFoodItemsId(int foodItemsId) {
        FoodItemsId = foodItemsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
