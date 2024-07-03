//import Controller.FoodItemController;
//import Controller.OrderController;
//import Controller.RestaurantController;
//import Controller.UserController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class OwnerUi {
//    static Scanner sc = new Scanner(System.in);
//    static UserController userController = new UserController();
//    static RestaurantController restaurantController = new RestaurantController();
//    static FoodItemController foodItemController = new FoodItemController();
//    static OrderController orderController = new OrderController();
//
//
//    public static void ownerUi(String username , String email , String password){
//        ownerMenu:
//        while (true){
//            System.out.println("0.  View profile");
//            System.out.println("1.  Display your restaurant and its menu");
//            System.out.println("2.  Add item to menu");
//            System.out.println("3.  Remove item from menu");
//            System.out.println("4.  Update food item price");
//            System.out.println("5.  Update Order Status");
//            System.out.println("6.  Logout");
//            System.out.println("7.  Exit");
//            System.out.println("8.  Register restaurant");
//            System.out.println("9.  Update restaurant");
//            System.out.println("10. Remove restaurant");
//            System.out.println("11. Back to Login page");
//            int choice = 9999;
//            try {
//                choice = sc.nextInt();
//            }
//            catch (Exception e){
//                System.out.println(e + "👾👾Try again");
//                System.out.println();
//                System.out.println();
//            }
//            sc.nextLine();
//            switch (choice) {
//                case 0:  //  To view their profile
//                    List<String> userProfile = userController.getProfile(username,password,email);
//                    Map<String, String> restaurantList = restaurantController.getRestaurantListOf(email);
//                    System.out.println("Username :  " + username);
//                    System.out.println("Email    :  " + email);
//                    for (String element : userProfile) {
//                        System.out.println(element);
//                    }
//                    for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                        System.out.println("Restaurant Name : " + entry.getValue() + "  Id : " + entry.getKey());
//                    }
//                    break;
//                case 1: // Display your restaurant and its menu
//                    restaurantList = restaurantController.getRestaurantListOf(email);
//                    if (restaurantList.isEmpty()) {
//                        System.out.println("You have not registered your restaurant yet.");
//                        System.out.println("1. Register restaurant");
//                        System.out.println("2. Logout");
//                        System.out.println("3. Exit");
//                        System.out.println("4. Back to previous menu");
//                        try {
//                            choice = sc.nextInt();
//                        } catch (Exception e) {
//                            System.out.println("Invalid input. Please enter a number from the menu.");
//                            sc.nextLine(); // consume the leftover newline
//                            continue;
//                        }
//                        sc.nextLine();
//
//                        switch (choice) {
//                            case 1:
//                                System.out.println("Enter restaurant details:");
//                                System.out.print("Restaurant name: ");
//                                String restaurantName;
//                                while (true){
//                                    restaurantName = sc.nextLine();
//                                    if (HelperClass.restaurantNameValidate(restaurantName)){
//                                        break;
//                                    }
//                                    System.out.println("Enter restaurant name :");
//                                }
//                                System.out.print("Location: ");
//                                String location = sc.nextLine();
//                                System.out.print("Phone number: ");
//                                String phone = sc.nextLine();
//                                String restaurantID = HelperClass.generateRandomNumberId(3);
//                                String id = restaurantController.registerRestaurant(email,restaurantID, restaurantName, location, phone);
//                                System.out.println("Id of your restaurant is : " + id);
//                                System.out.println();
//                                break;
//                            case 2:
//                                System.out.println("Logging out...");
//                                System.out.println();
//                                break ownerMenu;
//                            case 3:
//                                System.out.println("Exiting application...");
//                                return;
//                            case 4:
//                                break;
//                            default:
//                                System.out.println("Invalid option. Please select a valid option.");
//                        }
//                    } else {
//                        System.out.println("Your registered restaurants name & Id");
//                        for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                            String restaurantId = entry.getKey();
//                            String restaurantName = entry.getValue();
//                            System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
//                        }
//                        System.out.print("Enter restaurant Id to check their menu: ");
//                        String restaurantId;
//                        boolean isValidId = false;
//
//                        while (true) {
//                            restaurantId = sc.nextLine();
//                            if (restaurantId.equals("0")){
//                                break;
//                            }
//                            for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                if (entry.getKey().equals(restaurantId)) {
//                                    isValidId = true;
//                                    break;
//                                }
//                            }
//                            if (isValidId) {
//                                break;
//                            } else {
//                                System.out.print("Enter a valid restaurant Id: ");
//                            }
//                        }
//                        Map<String, String> restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restaurantId);
//                        if (restaurantMenu.isEmpty()) {
//                            System.out.println("There is no menu added yet");
//                            System.out.println("1. Add menu");
//                            System.out.println("2. Exit");
//                            System.out.println("3. Back to previous menu");
//
//                            try {
//                                choice = sc.nextInt();
//                            } catch (Exception e) {
//                                System.out.println("Invalid input. Please enter a number from the menu.");
//                                continue;
//                            }
//                            sc.nextLine(); // consume the leftover newline
//                            if (choice == 1) {
//                                System.out.print("Enter item to add: ");
//                                String itemToAdd = sc.nextLine();
//                                System.out.print("Enter price for " + itemToAdd + " : ");
//                                int price;
//                                try {
//                                    price = sc.nextInt();
//                                } catch (Exception e) {
//                                    System.out.println("Invalid item price.");
//                                    sc.nextLine(); // consume the leftover newline
//                                    continue;
//                                }
//                                String foodItemId = HelperClass.generateRandomNumberId(2);
//                                foodItemController.addItem(foodItemId , itemToAdd, restaurantId , price);
//                                System.out.println("Item added successfully");
//                            } else if (choice == 2) {
//                                break ownerMenu;
//                            } else if (choice == 3) {
//                                break;
//                            } else {
//                                System.out.println("Invalid option. Please select a valid option.");
//                            }
//                        } else {
//                            System.out.println("Menu");
//                            for (Map.Entry<String, String> entry : restaurantMenu.entrySet()) {
//                                String  foodItemId = entry.getKey();
//                                String foodItemName = entry.getValue();
//                                int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                                System.out.println("Item name: " + foodItemName + "  Id: " + foodItemId + "  price : " + priceOfItem);
//                            }
//                        }
//                    }
//                    break;
//                case 2: // Add item in menu
//                    restaurantList = restaurantController.getRestaurantListOf(email);
//                    System.out.println("Your registered restaurants name & Id");
//                    for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                        String restaurantId = entry.getKey();
//                        String restaurantName = entry.getValue();
//                        System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
//                    }
//                    System.out.println("Enter restaurant Id to add item in their menu:");
//                    String restaurantId = sc.nextLine();
//                    int  isValidRestaurantId = restaurantController.isValidRestaurantId(username , email , restaurantId);
//                    if (isValidRestaurantId == 0){
//                        System.out.println("Invalid restaurant id");
//                        break;
//                    } else if (isValidRestaurantId == 1) {
//                        System.out.println("Next time please select your restaurant id only");
//                        break;
//                    }
//                    System.out.print("Enter item to add: ");
//                    String itemToAdd = sc.nextLine();
//                    System.out.print("Enter price for " + itemToAdd + " : ");
//                    int price;
//                    try {
//                        price = sc.nextInt();
//                    } catch (Exception e) {
//                        System.out.println("Invalid item price.");
//                        sc.nextLine(); // consume the leftover newline
//                        continue;
//                    }
//                    String foodItemId = HelperClass.generateRandomNumberId(2);
//                    foodItemController.addItem(foodItemId , itemToAdd, restaurantId , price);
//                    System.out.println("Item added successfully");
//                    break;
//                case 3:  // Remove an item from the menu
//                    Map<String , String>  restaurantListt = new HashMap<>();
//                    Map<String , String>  restaurantMenu = new HashMap<>();
//
//                    restaurantListt = restaurantController.getRestaurantListOf(email);
//                    for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                        String restauranttId = entry.getKey();
//                        String restaurantName = entry.getValue();
//                        System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//
//                        restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restauranttId);
//                        for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                            foodItemId = entry1.getKey();
//                            String foodItemName = entry1.getValue();
//                            int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                            System.out.println("Food Id : " + foodItemId + "   Food Item Name : " + foodItemName + "  price : " + priceOfItem);
//                        }
//                    }
//                    String id1;
//                    while (true) {
//                        boolean found = false;
//                        System.out.println("Choose Restaurant id to remove their food item from menu: ");
//                        id1 = sc.nextLine();
//                        for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                            if (entry.getKey().equals(id1)) {
//                                found = true;
//                                break;
//                            }
//                        }
//                        if (found) {
//                            break;
//                        } else {
//                            System.out.println("Invalid Restaurant id. Try again.");
//                        }
//                    }
//                    restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(id1);
//                    if (!restaurantMenu.isEmpty()){
//                        String id2;
//                        while (true){
//                            boolean found = false;
//                            System.out.println("Choose item id to remove from menu : ");
//                            id2 = sc.nextLine();
//                            for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                if (entry1.getKey().equals(id2)){
//                                    found = true;
//                                    break;
//                                }
//                            }
//                            if (found){
//                                foodItemController.removeItem(id1 , id2);
//                                System.out.println("Item removed successfully");
//                                break;
//                            }
//                            else {
//                                System.out.println("Invalid food item id");
//                                break;
//                            }
//                        }
//
//                    }
//                    else {
//                        System.out.println("No item available for this restaurant yet");
//                    }
//                    break;
//                case 4:  // update food item price
//                    restaurantListt = restaurantController.getRestaurantListOf(email);
//                    for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                        String restauranttId = entry.getKey();
//                        String restaurantName = entry.getValue();
//                        System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//
//                        restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restauranttId);
//                        for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                            foodItemId = entry1.getKey();
//                            String foodItemName = entry1.getValue();
//                            int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                            System.out.println("Food Id : " + foodItemId + "   Food Item Name : " + foodItemName + "  price : " + priceOfItem);
//                        }
//                    }
//                    while (true) {
//                        boolean found = false;
//                        System.out.println("Choose Restaurant id to select their food item menu: ");
//                        id1 = sc.nextLine();
//                        if (id1.equals("0")){
//                            break;
//                        }
//                        for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                            if (entry.getKey().equals(id1)) {
//                                found = true;
//                                break;
//                            }
//                        }
//                        if (found) {
//                            break;
//                        } else {
//                            System.out.println("Invalid Restaurant id. Try again.");
//                        }
//                    }
//                    restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(id1);
//                    if (!restaurantMenu.isEmpty()){
//                        String id2;
//                        while (true){
//                            boolean found = false;
//                            System.out.println("Choose item id to update their price : ");
//                            id2 = sc.nextLine();
//                            if (id2.equals("0")){
//                                break;
//                            }
//                            for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                if (entry1.getKey().equals(id2)){
//                                    found = true;
//                                    break;
//                                }
//                            }
//                            if (found){
//                                System.out.print("Enter price or -1 for back in previous page: ");
//                                String newPrice = sc.nextLine();
//                                if (newPrice.equals("-1")){
//                                    break;
//                                }
//                                foodItemController.updateItemPrice(id1 , id2 , newPrice);
//                                System.out.println("Price updated");
//                                break;
//                            }
//                            else {
//                                System.out.println("Invalid food item id");
//                                break;
//                            }
//                        }
//                    }
//                    else {
//                        System.out.println("No item available for this restaurant yet");
//                    }
//                    break;
//                case 5: // Checking Order Request & Updating Order Status
//                    List<String> checkingOrderRequest;
//                    int flag = 0;
//                    Map<String, String> restaurantList3 = restaurantController.getRestaurantListOf(email);
//                    for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                        restaurantId = entry.getKey();
//                        checkingOrderRequest = orderController.checkingOrderRequest(restaurantId);
//                        if (!checkingOrderRequest.isEmpty()){
//                            flag = 1;
//                        }
//                        for (String orderId : checkingOrderRequest) {
//                            if (orderController.deliverOrder(orderId)) {
//                                System.out.println("Order id " + orderId + " is IN_PROGRESS   ------>>>>>>  COMPLETED");
//                            }
//                            System.out.println();
//                        }
//                    }
//                    if (flag == 0){
//                        System.out.println("No order is PENDING");
//                    }
//                    break;
//                case 6:  // Log out...
//                    System.out.println("Logging out...");
//                    break ownerMenu;
//                case 7:  // Quit from application
//                    System.out.print("For confirmation -> ");
//                    System.out.println("Enter 0 for Exit else back to previous page");
//                    String exitCode = sc.nextLine();
//                    if (exitCode.equals("0")){
//                        return;
//                    }
//                    break;
//                case 8:  //  register restaurant
//                    System.out.println("Enter restaurant details");
//                    System.out.print("Restaurant name: ");
//                    String restaurantName;
//                    int isRestaurantExist;
//                    while (true) {
//                        restaurantName = sc.nextLine();
//                        isRestaurantExist = restaurantController.isRestaurantExist(restaurantName, email);
//                        if (isRestaurantExist == 0) {
//                            break;
//                        } else if (isRestaurantExist == 2) {
//                            System.out.println("you have already registered this restaurant , Thanks you😊");
//                            break;
//                        }
//                        else {
//                            System.out.println("Restaurant name is already registered by a different user");
//                            break;
//                        }
//                    }
//                    if (isRestaurantExist == 2 || isRestaurantExist == 1){
//                        break;
//                    }
//                    System.out.print("Location: ");
//                    String location = sc.nextLine();
//                    System.out.print("Phone number: ");
//                    String phone = sc.nextLine();
//                    String restaurantID = HelperClass.generateRandomNumberId(3);
//                    String registrationStatus = restaurantController.registerRestaurant(email,restaurantID, restaurantName, location, phone);
//                    System.out.println("Id of your restaurant is: " + registrationStatus);
//                    System.out.println();
//                    break;
//                case 9:  //  Update restaurant < Name , Address  , email , phone , status >
//                    System.out.println("1. Update restaurant name");
//                    System.out.println("2. Update restaurant address");
//                    System.out.println("3. Update restaurant phone");
//                    System.out.println("0. back to previous page");
//                    while (true){
//                        try {
//                            choice = sc.nextInt();
//                        }
//                        catch (Exception e){
//                            System.out.println("Enter a valid choice....:");
//                            continue;
//                        }
//                        if (choice == 1){  //  Update restaurant name
//                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                String restauranttId = entry.getKey();
//                                restaurantName = entry.getValue();
//                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                            }
//                            System.out.println("Choose Restaurant id to update their name: ");
//                            while (true) {
//                                boolean found = false;
//                                id1 = sc.nextLine();
//                                if (id1.equals("0")){
//                                    break;
//                                }
//                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                    if (entry.getKey().equals(id1)) {
//                                        found = true;
//                                        break;
//                                    }
//                                }
//                                if (found) {
//                                    System.out.print("Enter restaurant name (new name) : ");
//                                    String newRestaurantName = sc.nextLine();
//                                    if (newRestaurantName.equals("0")){
//                                        break;
//                                    }
//                                    restaurantController.updateRestaurantName(id1 , email , newRestaurantName);
//                                    System.out.println("Restaurant name updated");
//                                    break;
//                                } else {
//                                    System.out.println("Invalid Restaurant id. Try again.");
//                                }
//                            }
//                            break;
//                        }
//                        else if (choice == 2){  //  updating address of restaurant
//                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                String restauranttId = entry.getKey();
//                                restaurantName = entry.getValue();
//                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                            }
//                            System.out.println("Choose Restaurant id to update their address: ");
//                            while (true) {
//                                boolean found = false;
//                                id1 = sc.nextLine();
//                                if (id1.equals("0")){
//                                    break;
//                                }
//                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                    if (entry.getKey().equals(id1)) {
//                                        found = true;
//                                        break;
//                                    }
//                                }
//                                if (found) {
//                                    System.out.print("Enter restaurant address (new address) : ");
//                                    String newRestaurantAddress = sc.nextLine();
//                                    if (newRestaurantAddress.equals("0")){
//                                        break;
//                                    }
//                                    restaurantController.updateRestaurantAddress(id1 , email , newRestaurantAddress);
//                                    System.out.println("Restaurant Address updated");
//                                    break;
//                                } else {
//                                    System.out.println("Invalid Restaurant id. Try again.");
//                                }
//                            }
//                            break;
//                        } else if (choice == 3) {   //  updating phone number
//                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                String restauranttId = entry.getKey();
//                                restaurantName = entry.getValue();
//                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                            }
//                            System.out.println("Choose Restaurant id to update their phone number: ");
//                            while (true) {
//                                boolean found = false;
//                                id1 = sc.nextLine();
//                                if (id1.equals("0")){
//                                    break;
//                                }
//                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                    if (entry.getKey().equals(id1)) {
//                                        found = true;
//                                        break;
//                                    }
//                                }
//                                if (found) {
//                                    System.out.print("Enter restaurant phone number (new phone number) : ");
//                                    String newRestaurantPhone;
//                                    while (true){
//                                        newRestaurantPhone = sc.nextLine();
//                                        if (HelperClass.validatePhone(newRestaurantPhone)){
//                                            break;
//                                        }
//                                        System.out.print("Enter valid phone number : ");
//                                        if (newRestaurantPhone.equals("0")){
//                                            break;
//                                        }
//                                    }
//                                    if (newRestaurantPhone.equals("0")){
//                                        break;
//                                    }
//                                    restaurantController.updateRestaurantPhone(id1 , email , newRestaurantPhone);
//                                    System.out.println("Restaurant phone number updated");
//                                    break;
//                                } else {
//                                    System.out.println("Invalid Restaurant id. Try again.");
//                                }
//                            }
//                            break;
//                        } else if (choice == 0) {
//                            break;
//                        } else {
//                            System.out.println("Enter a valid choice : ");
//                        }
//                    }
//                    break;
//                case 10:  //  discontinue restaurant
//                    System.out.println("Are you sure you want to discontinue your restaurant?");
//                    System.out.println("Enter false to back else true");
//                    if (sc.nextLine().equals("true")) {
//                        System.out.println("Select restaurant to discontinue");
//                        restaurantList3 = restaurantController.getRestaurantListOf(email);
//                        System.out.println("Your restaurants:");
//                        for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                            restaurantId = entry.getKey();
//                            restaurantName = entry.getValue();
//                            System.out.println("Restaurant id  " + restaurantId + "     Restaurant name  " + restaurantName);
//                        }
//                        System.out.print("Enter restaurant id: ");
//                        while (true) {
//                            String restaurantChoice = sc.nextLine();
//                            if (restaurantChoice.equals("0")){
//                                break;
//                            }
//                            boolean isValidId = false;
//
//                            for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                                if (entry.getKey().equals(restaurantChoice)) {
//                                    isValidId = true;
//                                    break;
//                                }
//                            }
//                            if (isValidId) {
//                                restaurantController.discontinueRestaurant(restaurantChoice);
//                                break;
//                            } else {
//                                System.out.print("Enter a valid restaurant Id: ");
//                            }
//                        }
//                    }
//                    break;
//                case 11:  // back to login page
//                    break ownerMenu;
//
//                default:
//                    System.out.println("Invalid option. Please select a valid option.");
//                    break;
//            }
//        }
//    }
//}