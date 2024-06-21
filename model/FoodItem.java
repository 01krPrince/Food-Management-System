package model;

public class FoodItem {
    private String restaurantname;
    private String item;
    private int FoodItemsId;

    public FoodItem(String restaurantname, String item , int foodItemId) {
        this.restaurantname = restaurantname;
        this.item = item;
        this.FoodItemsId = foodItemId;
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
}
