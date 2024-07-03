package Model;

public class FoodItem {
    private String restaurantName;
    private String foodItemName;
    private String FoodItemsId;
    private String status;
    private String restaurantId;
    private int price;

    public FoodItem(String foodItemName, String foodItemId , String restaurantName , String restaurantId , int price) {
        this.restaurantName = restaurantName;
        this.foodItemName = foodItemName;
        this.FoodItemsId = foodItemId;
        this.status = "available";
        this.restaurantId = restaurantId;
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getfoodItemName() {
        return foodItemName;
    }

    public void setfoodItemName(String item) {
        this.foodItemName = item;
    }

    public String  getFoodItemsId() {
        return FoodItemsId;
    }

    public void setFoodItemsId(String  foodItemsId) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
