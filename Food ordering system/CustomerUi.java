//import Controller.FoodItemController;
//import Controller.OrderController;
//import Controller.RestaurantController;
//import Controller.UserController;
//
//
//import java.util.*;
//
//public class UI {
//
//    public static void main(String[] args) {
//
//        UserController userController = new UserController();
//        RestaurantController restaurantController = new RestaurantController();
//        FoodItemController foodItemController = new FoodItemController();
//        OrderController orderController = new OrderController();
//
//        HelperClass helperClass = new HelperClass();
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Welcome to the Food Ordering System Application");
//
//        int choice = 9999;
//        while (true) {
//            System.out.println("Please select an option:");
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//            try {
//                choice = sc.nextInt();
//            } catch (Exception e) {
//                System.out.println(e + "👾");
//                System.out.println("Try again");
//                sc.nextLine(); // consume the leftover newline
//                continue;
//            }
//            sc.nextLine(); // consume the leftover newline
//            if (choice == 1) {
//                String username;
//                System.out.print("Enter your name: ");
//                while (true) {
//                    username = sc.nextLine();
//                    if (HelperClass.validateNameWithoutSpecialCharacters(username)) {
//                        break;
//                    }
//                    System.out.println("Invalid name. Please enter a name without special characters:");
//                }
//
//                String email;
//                System.out.print("Enter your email: ");
//                while (true) {
//                    email = sc.nextLine();
//                    if (helperClass.validateEmail(email)) {
//                        if (!userController.isEmailExist(email)) {
//                            break;
//                        }
//                        System.out.println("This email is registered already.");
//                        System.out.println("1. Enter a different email");
//                        System.out.println("2. Go back to the main menu");
//                        try {
//                            choice = sc.nextInt();
//                            sc.nextLine(); // consume the leftover newline
//                        } catch (Exception e) {
//                            System.out.println(e + "👾👾 Try again with a valid choice");
//                            sc.nextLine(); // consume the leftover newline
//                            continue;
//                        }
//                        if (choice == 1) {
//                            continue;
//                        } else if (choice == 2) {
//                            break;
//                        } else {
//                            System.out.println("Invalid option. Please select a valid option.");
//                        }
//                    } else {
//                        System.out.println("Invalid email address. Please enter a valid email address:");
//                    }
//                }
//
//                if (choice == 2) {
//                    continue; //  back to the main menu
//                }
//
//                String role;
//                System.out.print("Enter your role (owner or customer): ");
//                while (true) {
//                    role = sc.nextLine();
//                    if (HelperClass.validateRole(role)) {
//                        break;
//                    }
//                    System.out.println("Invalid role. Please choose 'owner' or 'customer':");
//                }
//                role = role.toLowerCase();
//
//                String password;
//                System.out.print("Enter a strong password (Example@123): ");
//                while (true) {
//                    String messageFromPassManager = HelperClass.validatePassword(password = sc.nextLine());
//                    if (messageFromPassManager.equals("valid")) {
//                        break;
//                    }
//                    System.out.println(messageFromPassManager);
//                    System.out.print("Please enter a strong password (Example@123): ");
//                }
//
//                String registrationStatus = userController.registerUser(username, email, role, password);
//                System.out.println(registrationStatus);
//                System.out.println();
//
//                if (role.equals("owner")) {
//                    System.out.println("Enter your restaurant details:");
//                    System.out.print("Restaurant name: ");
//                    String restaurantName;
//                    int isRestaurantExist;
//                    while (true) {
//                        while (true){
//                            restaurantName = sc.nextLine();
//                            if (helperClass.restaurantNameValidate(restaurantName)){
//                                break;
//                            }
//                            System.out.println("Enter restaurant name :");
//                        }
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
//                        continue;
//                    }
//                    System.out.print("Location: ");
//                    String location = sc.nextLine();
//                    System.out.print("Phone number: ");
//                    String phone;
//                    while (true) {
//                        phone = sc.nextLine();
//                        if (helperClass.validatePhone(phone)) {
//                            if (!restaurantController.isphoneExist(phone)){
//                                break;
//                            }
//                            System.out.println("Enter YOUR phone number please");
//                            continue;
//                        }
//                        System.out.println("Enter a valid phone number");
//                    }
//
//                    int id = restaurantController.registerRestaurant(email, restaurantName, location, phone);
//                    System.out.println("Id of your restaurant is: " + id);
//                    System.out.println();
//                }
//            } else if (choice == 2) {
//                System.out.print("Enter your name: ");
//                String username = sc.nextLine();
//                if (username.equals("0")){
//                    break;
//                }
//                System.out.print("Enter your email: ");
//                String email = sc.nextLine();
//                System.out.print("Enter your password: ");
//                String password = sc.nextLine();
//                boolean loginStatus = userController.loginUser(email, password);
//                if (loginStatus) {
//                    System.out.println("Login successful");
//                } else {
//                    System.out.println("Credentials not match in our entire repository, please register first!");
//                }
//                System.out.println();
//                if (loginStatus) {
//                    String role = userController.getRole(email, password);
//                    if (role.equals("owner")) {
//                        ownerMenu:
//                        while (true) {
//                            System.out.println();
//                            System.out.println("0.  View profile");
//                            System.out.println("1.  Display your restaurant and its menu");
//                            System.out.println("2.  Add item to menu");
//                            System.out.println("3.  Remove item from menu");
//                            System.out.println("4.  Update food item price");
//                            System.out.println("5.  Update Order Status");
//                            System.out.println("6.  Logout");
//                            System.out.println("7.  Exit");
//                            System.out.println("8.  Register restaurant");
//                            System.out.println("9.  Update restaurant");
//                            System.out.println("10. Remove restaurant");
//                            System.out.println("11. Back to Login page");
//                            try {
//                                choice = sc.nextInt();
//                            }
//                            catch (Exception e){
//                                System.out.println(e + "👾👾Try again");
//                                System.out.println();
//                                System.out.println();
//                            }
//                            sc.nextLine();
//                            switch (choice) {
//                                case 0:  //  To view their profile
//                                    List<String> userProfile = userController.getProfile(username,password,email);
//                                    Map<String, String> restaurantList = restaurantController.getRestaurantListOf(email);
//                                    System.out.println("Username :  " + username);
//                                    System.out.println("Email    :  " + email);
//                                    for (String element : userProfile) {
//                                        System.out.println(element);
//                                    }
//                                    for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                        System.out.println("Restaurant Name : " + entry.getValue() + "  Id : " + entry.getKey());
//                                    }
//                                    break;
//                                case 1: // Display your restaurant and its menu
//                                    restaurantList = restaurantController.getRestaurantListOf(email);
//                                    if (restaurantList.isEmpty()) {
//                                        System.out.println("You have not registered your restaurant yet.");
//                                        System.out.println("1. Register restaurant");
//                                        System.out.println("2. Logout");
//                                        System.out.println("3. Exit");
//                                        System.out.println("4. Back to previous menu");
//                                        try {
//                                            choice = sc.nextInt();
//                                        } catch (Exception e) {
//                                            System.out.println("Invalid input. Please enter a number from the menu.");
//                                            sc.nextLine(); // consume the leftover newline
//                                            continue;
//                                        }
//                                        sc.nextLine();
//
//                                        switch (choice) {
//                                            case 1:
//                                                System.out.println("Enter restaurant details:");
//                                                System.out.print("Restaurant name: ");
//                                                System.out.print("Restaurant name: ");
//                                                String restaurantName;
//                                                while (true){
//                                                    restaurantName = sc.nextLine();
//                                                    if (helperClass.restaurantNameValidate(restaurantName)){
//                                                        break;
//                                                    }
//                                                    System.out.println("Enter restaurant name :");
//                                                }
//                                                System.out.print("Location: ");
//                                                String location = sc.nextLine();
//                                                System.out.print("Phone number: ");
//                                                String phone = sc.nextLine();
//                                                int id = restaurantController.registerRestaurant(email, restaurantName, location, phone);
//                                                System.out.println("Id of your restaurant is : " + id);
//                                                System.out.println();
//                                                break;
//                                            case 2:
//                                                System.out.println("Logging out...");
//                                                System.out.println();
//                                                break ownerMenu;
//                                            case 3:
//                                                System.out.println("Exiting application...");
//                                                return;
//                                            case 4:
//                                                break;
//                                            default:
//                                                System.out.println("Invalid option. Please select a valid option.");
//                                        }
//                                    } else {
//                                        System.out.println("Your registered restaurants name & Id");
//                                        for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                            String restaurantId = entry.getKey();
//                                            String restaurantName = entry.getValue();
//                                            System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
//                                        }
//                                        System.out.print("Enter restaurant Id to check their menu: ");
//                                        String restaurantId;
//                                        boolean isValidId = false;
//
//                                        while (true) {
//                                            restaurantId = sc.nextLine();
//                                            if (restaurantId.equals("0")){
//                                                break;
//                                            }
//                                            for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                                if (entry.getKey().equals(restaurantId)) {
//                                                    isValidId = true;
//                                                    break;
//                                                }
//                                            }
//                                            if (isValidId) {
//                                                break;
//                                            } else {
//                                                System.out.print("Enter a valid restaurant Id: ");
//                                            }
//                                        }
//                                        Map<String, String> restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restaurantId);
//                                        if (restaurantMenu.isEmpty()) {
//                                            System.out.println("There is no menu added yet");
//                                            System.out.println("1. Add menu");
//                                            System.out.println("2. Exit");
//                                            System.out.println("3. Back to previous menu");
//
//                                            try {
//                                                choice = sc.nextInt();
//                                            } catch (Exception e) {
//                                                System.out.println("Invalid input. Please enter a number from the menu.");
//                                                continue;
//                                            }
//                                            sc.nextLine(); // consume the leftover newline
//                                            if (choice == 1) {
//                                                System.out.print("Enter item to add: ");
//                                                String itemToAdd = sc.nextLine();
//                                                System.out.print("Enter price for " + itemToAdd + " : ");
//                                                int price;
//                                                try {
//                                                    price = sc.nextInt();
//                                                } catch (Exception e) {
//                                                    System.out.println("Invalid item price.");
//                                                    sc.nextLine(); // consume the leftover newline
//                                                    continue;
//                                                }
//                                                foodItemController.addItem(itemToAdd, restaurantId , price);
//                                                System.out.println("Item added successfully");
//                                            } else if (choice == 2) {
//                                                break ownerMenu;
//                                            } else if (choice == 3) {
//                                                break;
//                                            } else {
//                                                System.out.println("Invalid option. Please select a valid option.");
//                                            }
//                                        } else {
//                                            System.out.println("Menu");
//                                            for (Map.Entry<String, String> entry : restaurantMenu.entrySet()) {
//                                                String  foodItemId = entry.getKey();
//                                                String foodItemName = entry.getValue();
//                                                int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                                                System.out.println("Item name: " + foodItemName + "  Id: " + foodItemId + "  price : " + priceOfItem);
//                                            }
//                                        }
//                                    }
//                                    break;
//                                case 2: // Add item in menu
//                                    restaurantList = restaurantController.getRestaurantListOf(email);
//                                    System.out.println("Your registered restaurants name & Id");
//                                    for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                        String restaurantId = entry.getKey();
//                                        String restaurantName = entry.getValue();
//                                        System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
//                                    }
//                                    System.out.println("Enter restaurant Id to add item in their menu:");
//                                    String restaurantId = sc.nextLine();
//                                    int  isValidRestaurantId = restaurantController.isValidRestaurantId(username , email , restaurantId);
//                                    if (isValidRestaurantId == 0){
//                                        System.out.println("Invalid restaurant id");
//                                        break;
//                                    } else if (isValidRestaurantId == 1) {
//                                        System.out.println("Next time please select your restaurant id only");
//                                        break;
//                                    }
//                                    System.out.print("Enter item to add: ");
//                                    String itemToAdd = sc.nextLine();
//                                    System.out.print("Enter price for " + itemToAdd + " : ");
//                                    int price;
//                                    try {
//                                        price = sc.nextInt();
//                                    } catch (Exception e) {
//                                        System.out.println("Invalid item price.");
//                                        sc.nextLine(); // consume the leftover newline
//                                        continue;
//                                    }
//                                    foodItemController.addItem(itemToAdd, restaurantId , price);
//                                    System.out.println("Item added successfully");
//                                    break;
//                                case 3:  // Remove an item from the menu
//                                    Map<String , String>  restaurantListt = new HashMap<>();
//                                    Map<String , String>  restaurantMenu = new HashMap<>();
//
//                                    restaurantListt = restaurantController.getRestaurantListOf(email);
//                                    for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                        String restauranttId = entry.getKey();
//                                        String restaurantName = entry.getValue();
//                                        System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//
//                                        restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restauranttId);
//                                        for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                            String foodItemId = entry1.getKey();
//                                            String foodItemName = entry1.getValue();
//                                            int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                                            System.out.println("Food Id : " + foodItemId + "   Food Item Name : " + foodItemName + "  price : " + priceOfItem);
//                                        }
//                                    }
//                                    String id1;
//                                    while (true) {
//                                        boolean found = false;
//                                        System.out.println("Choose Restaurant id to remove their food item from menu: ");
//                                        id1 = sc.nextLine();
//                                        for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                            if (entry.getKey().equals(id1)) {
//                                                found = true;
//                                                break;
//                                            }
//                                        }
//                                        if (found) {
//                                            break;
//                                        } else {
//                                            System.out.println("Invalid Restaurant id. Try again.");
//                                        }
//                                    }
//                                    restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(id1);
//                                    if (!restaurantMenu.isEmpty()){
//                                        String id2;
//                                        while (true){
//                                            boolean found = false;
//                                            System.out.println("Choose item id to remove from menu : ");
//                                            id2 = sc.nextLine();
//                                            for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                                if (entry1.getKey().equals(id2)){
//                                                    found = true;
//                                                    break;
//                                                }
//                                            }
//                                            if (found){
//                                                foodItemController.removeItem(id1 , id2);
//                                                System.out.println("Item removed successfully");
//                                                break;
//                                            }
//                                            else {
//                                                System.out.println("Invalid food item id");
//                                                break;
//                                            }
//                                        }
//
//                                    }
//                                    else {
//                                        System.out.println("No item available for this restaurant yet");
//                                    }
//                                    break;
//                                case 4:  // update food item price
//                                    restaurantListt = restaurantController.getRestaurantListOf(email);
//                                    for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                        String restauranttId = entry.getKey();
//                                        String restaurantName = entry.getValue();
//                                        System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//
//                                        restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restauranttId);
//                                        for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                            String foodItemId = entry1.getKey();
//                                            String foodItemName = entry1.getValue();
//                                            int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                                            System.out.println("Food Id : " + foodItemId + "   Food Item Name : " + foodItemName + "  price : " + priceOfItem);
//                                        }
//                                    }
//                                    while (true) {
//                                        boolean found = false;
//                                        System.out.println("Choose Restaurant id to select their food item menu: ");
//                                        id1 = sc.nextLine();
//                                        if (id1.equals("0")){
//                                            break;
//                                        }
//                                        for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                            if (entry.getKey().equals(id1)) {
//                                                found = true;
//                                                break;
//                                            }
//                                        }
//                                        if (found) {
//                                            break;
//                                        } else {
//                                            System.out.println("Invalid Restaurant id. Try again.");
//                                        }
//                                    }
//                                    restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(id1);
//                                    if (!restaurantMenu.isEmpty()){
//                                        String id2;
//                                        while (true){
//                                            boolean found = false;
//                                            System.out.println("Choose item id to update their price : ");
//                                            id2 = sc.nextLine();
//                                            if (id2.equals("0")){
//                                                break;
//                                            }
//                                            for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
//                                                if (entry1.getKey().equals(id2)){
//                                                    found = true;
//                                                    break;
//                                                }
//                                            }
//                                            if (found){
//                                                System.out.print("Enter price or -1 for back in previous page: ");
//                                                String newPrice = sc.nextLine();
//                                                if (newPrice.equals("-1")){
//                                                    break;
//                                                }
//                                                foodItemController.updateItemPrice(id1 , id2 , newPrice);
//                                                System.out.println("Price updated");
//                                                break;
//                                            }
//                                            else {
//                                                System.out.println("Invalid food item id");
//                                                break;
//                                            }
//                                        }
//                                    }
//                                    else {
//                                        System.out.println("No item available for this restaurant yet");
//                                    }
//                                    break;
//                                case 5: // Checking Order Request & Updating Order Status
//                                    List<String> checkingOrderRequest;
//                                    int flag = 0;
//                                    Map<String, String> restaurantList3 = restaurantController.getRestaurantListOf(email);
//                                    for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                                        restaurantId = entry.getKey();
//                                        checkingOrderRequest = orderController.checkingOrderRequest(restaurantId);
//                                        if (!checkingOrderRequest.isEmpty()){
//                                            flag = 1;
//                                        }
//                                        for (String orderId : checkingOrderRequest) {
//                                            if (orderController.deliverOrder(orderId)) {
//                                                System.out.println("Order id " + orderId + " is IN_PROGRESS   ------>>>>>>  COMPLETED");
//                                            }
//                                            System.out.println();
//                                        }
//                                    }
//                                    if (flag == 0){
//                                        System.out.println("No order is PENDING");
//                                    }
//                                    break;
//                                case 6:  // Log out...
//                                    System.out.println("Logging out...");
//                                    break ownerMenu;
//                                case 7:  // Quit from application
//                                    System.out.print("For confirmation -> ");
//                                    System.out.println("Enter 0 for Exit else back to previous page");
//                                    String exitCode = sc.nextLine();
//                                    if (exitCode.equals("0")){
//                                        return;
//                                    }
//                                    break;
//                                case 8:  //  register restaurant
//                                    System.out.println("Enter restaurant details");
//                                    System.out.print("Restaurant name: ");
//                                    String restaurantName;
//                                    int isRestaurantExist;
//                                    while (true) {
//                                        restaurantName = sc.nextLine();
//                                        isRestaurantExist = restaurantController.isRestaurantExist(restaurantName, email);
//                                        if (isRestaurantExist == 0) {
//                                            break;
//                                        } else if (isRestaurantExist == 2) {
//                                            System.out.println("you have already registered this restaurant , Thanks you😊");
//                                            break;
//                                        }
//                                        else {
//                                            System.out.println("Restaurant name is already registered by a different user");
//                                            break;
//                                        }
//                                    }
//                                    if (isRestaurantExist == 2 || isRestaurantExist == 1){
//                                        break;
//                                    }
//                                    System.out.print("Location: ");
//                                    String location = sc.nextLine();
//                                    System.out.print("Phone number: ");
//                                    String phone = sc.nextLine();
//                                    int registrationStatus = restaurantController.registerRestaurant(email, restaurantName, location, phone);
//                                    System.out.println("Id of your restaurant is: " + registrationStatus);
//                                    System.out.println();
//                                    break;
//                                case 9:  //  Update restaurant < Name , Address  , email , phone , status >
//                                    System.out.println("1. Update restaurant name");
//                                    System.out.println("2. Update restaurant address");
//                                    System.out.println("3. Update restaurant phone");
//                                    System.out.println("0. back to previous page");
//                                    while (true){
//                                        try {
//                                            choice = sc.nextInt();
//                                        }
//                                        catch (Exception e){
//                                            System.out.println("Enter a valid choice....:");
//                                            continue;
//                                        }
//                                        if (choice == 1){  //  Update restaurant name
//                                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                String restauranttId = entry.getKey();
//                                                restaurantName = entry.getValue();
//                                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                                            }
//                                            System.out.println("Choose Restaurant id to update their name: ");
//                                            while (true) {
//                                                boolean found = false;
//                                                id1 = sc.nextLine();
//                                                if (id1.equals("0")){
//                                                    break;
//                                                }
//                                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                    if (entry.getKey().equals(id1)) {
//                                                        found = true;
//                                                        break;
//                                                    }
//                                                }
//                                                if (found) {
//                                                    System.out.print("Enter restaurant name (new name) : ");
//                                                    String newRestaurantName = sc.nextLine();
//                                                    if (newRestaurantName.equals("0")){
//                                                        break;
//                                                    }
//                                                    restaurantController.updateRestaurantName(id1 , email , newRestaurantName);
//                                                    System.out.println("Restaurant name updated");
//                                                    break;
//                                                } else {
//                                                    System.out.println("Invalid Restaurant id. Try again.");
//                                                }
//                                            }
//                                            break;
//                                        }
//                                        else if (choice == 2){  //  updating address of restaurant
//                                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                String restauranttId = entry.getKey();
//                                                restaurantName = entry.getValue();
//                                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                                            }
//                                            System.out.println("Choose Restaurant id to update their address: ");
//                                            while (true) {
//                                                boolean found = false;
//                                                id1 = sc.nextLine();
//                                                if (id1.equals("0")){
//                                                    break;
//                                                }
//                                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                    if (entry.getKey().equals(id1)) {
//                                                        found = true;
//                                                        break;
//                                                    }
//                                                }
//                                                if (found) {
//                                                    System.out.print("Enter restaurant address (new address) : ");
//                                                    String newRestaurantAddress = sc.nextLine();
//                                                    if (newRestaurantAddress.equals("0")){
//                                                        break;
//                                                    }
//                                                    restaurantController.updateRestaurantAddress(id1 , email , newRestaurantAddress);
//                                                    System.out.println("Restaurant Address updated");
//                                                    break;
//                                                } else {
//                                                    System.out.println("Invalid Restaurant id. Try again.");
//                                                }
//                                            }
//                                            break;
//                                        } else if (choice == 3) {   //  updating phone number
//                                            restaurantListt = restaurantController.getRestaurantListOf(email);
//                                            for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                String restauranttId = entry.getKey();
//                                                restaurantName = entry.getValue();
//                                                System.out.println("Restaurant Id : " + restauranttId + "    Restaurant Name : " + restaurantName);
//                                            }
//                                            System.out.println("Choose Restaurant id to update their phone number: ");
//                                            while (true) {
//                                                boolean found = false;
//                                                id1 = sc.nextLine();
//                                                if (id1.equals("0")){
//                                                    break;
//                                                }
//                                                for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
//                                                    if (entry.getKey().equals(id1)) {
//                                                        found = true;
//                                                        break;
//                                                    }
//                                                }
//                                                if (found) {
//                                                    System.out.print("Enter restaurant phone number (new phone number) : ");
//                                                    String newRestaurantPhone;
//                                                    while (true){
//                                                        newRestaurantPhone = sc.nextLine();
//                                                        if (helperClass.validatePhone(newRestaurantPhone)){
//                                                            break;
//                                                        }
//                                                        System.out.print("Enter valid phone number : ");
//                                                        if (newRestaurantPhone.equals("0")){
//                                                            break;
//                                                        }
//                                                    }
//                                                    if (newRestaurantPhone.equals("0")){
//                                                        break;
//                                                    }
//                                                    restaurantController.updateRestaurantPhone(id1 , email , newRestaurantPhone);
//                                                    System.out.println("Restaurant phone number updated");
//                                                    break;
//                                                } else {
//                                                    System.out.println("Invalid Restaurant id. Try again.");
//                                                }
//                                            }
//                                            break;
//                                        } else if (choice == 0) {
//                                            break;
//                                        } else {
//                                            System.out.println("Enter a valid choice : ");
//                                        }
//                                    }
//                                    break;
//                                case 10:  //  discontinue restaurant
//                                    System.out.println("Are you sure you want to discontinue your restaurant?");
//                                    System.out.println("Enter false to back else true");
//                                    if (sc.nextLine().equals("true")) {
//                                        System.out.println("Select restaurant to discontinue");
//                                        restaurantList3 = restaurantController.getRestaurantListOf(email);
//                                        System.out.println("Your restaurants:");
//                                        for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                                            restaurantId = entry.getKey();
//                                            restaurantName = entry.getValue();
//                                            System.out.println("Restaurant id  " + restaurantId + "     Restaurant name  " + restaurantName);
//                                        }
//                                        System.out.print("Enter restaurant id: ");
//                                        while (true) {
//                                            String restaurantChoice = sc.nextLine();
//                                            if (restaurantChoice.equals("0")){
//                                                break;
//                                            }
//                                            boolean isValidId = false;
//
//                                            for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
//                                                if (entry.getKey().equals(restaurantChoice)) {
//                                                    isValidId = true;
//                                                    break;
//                                                }
//                                            }
//                                            if (isValidId) {
//                                                restaurantController.discontinue(restaurantChoice);
//                                                break;
//                                            } else {
//                                                System.out.print("Enter a valid restaurant Id: ");
//                                            }
//                                        }
//                                    }
//                                    break;
//                                case 11:  // back to login page
//                                    break ownerMenu;
//
//                                default:
//                                    System.out.println("Invalid option. Please select a valid option.");
//                                    break;
//                            }
//                        }
//                    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                    else if (role.equals("customer")) {
//                        customerMenu:
//                        while (true) {
//                            System.out.println();
//                            System.out.println("0. View profile");
//                            System.out.println("1. Place an order");
//                            System.out.println("2. View order history");
//                            System.out.println("3. View order status");
//                            System.out.println("6. Cancel Order");
//                            System.out.println("4. Logout");
//                            System.out.println("5. Exit");
//                            try {
//                                choice = sc.nextInt();
//                            }
//                            catch (Exception e){
//                                System.out.println(e + "👾👾Try again");
//                                System.out.println();
//                                System.out.println();
//                            }
//                            sc.nextLine();
//
//                            switch (choice) {
//                                case 0:  //  To view their profile
//                                    List<String> userProfile = userController.getProfile(username,password,email);
//                                    Map<String, String> restaurantList = restaurantController.getRestaurantListOf(email);
//                                    System.out.println("username :  " + username);
//                                    for (String element : userProfile) {
//                                        System.out.println(element);
//                                    }
//                                    break;
//                                case 1:  //  Place an order
//                                    restaurantList = restaurantController.getAllAvailableRestaurantList();
//                                    if (restaurantList.isEmpty()){
//                                        System.out.println("Now, There is no restaurant available");
//                                    }
//                                    else {
//                                        String ifAddressAdded = userController.getAddress(username,email);
//                                        if (ifAddressAdded == null){
//                                            System.out.print("Enter your Address : ");
//                                            String address = sc.nextLine();
//                                            System.out.print("Enter phone number : ");
//                                            String phoneNo = sc.nextLine();
//                                            userController.saveAddressandPhoneOfCustomer(username , email , phoneNo , address);
//                                        }
//                                        System.out.println("Available Restaurants List and their menu");
//                                        for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
//                                            String restaurantId = entry.getValue();
//                                            String restaurantName = entry.getKey();
//                                            System.out.println("Restaurant Id : " +  restaurantId + "    Restaurant name : " + restaurantName);
//                                            Map<String , String> menuOfRestaurant = foodItemController.getRestaurantMenuByRestaurantId(restaurantId);
//                                            for (Map.Entry<String , String> entry1 : menuOfRestaurant.entrySet()) {
//                                                String foodItemName = entry1.getValue();
//                                                String  foodItemId = entry1.getKey();
//                                                int priceOfItem = foodItemController.getPrice(foodItemName , foodItemId);
//                                                System.out.println("Item id : " + foodItemId  +"   Item name : "  +  foodItemName  + "   Item price : " + priceOfItem);
//                                            }
//                                        }
//                                        System.out.print("Enter restaurant id : ");
//                                        String restaurantId;
//                                        while (true){
//                                            restaurantId  = sc.nextLine();
//                                            String finalRestaurantId = restaurantId;
//                                            if (restaurantController.getAllAvailableRestaurantList().values().stream().anyMatch(value -> value.contains(finalRestaurantId))){
//                                                break;
//                                            }
//                                            System.out.print("\nEnter a valid restaurant id : ");
//                                        }
//                                        String foodId;
//                                        System.out.print("Enter food id: ");
//                                        while (true) {
//                                            foodId = sc.nextLine();
//                                            if (foodId.equals("0")){
//                                                break;
//                                            }
//                                            Map<String, String> menuOfRestaurant = foodItemController.getRestaurantMenuByRestaurantId(restaurantId);
//                                            boolean isValidFoodId = false;
//
//                                            for (Map.Entry<String, String> entry1 : menuOfRestaurant.entrySet()) {
//                                                if (entry1.getKey().equals(foodId)) {
//                                                    isValidFoodId = true;
//                                                    break;
//                                                }
//                                            }
//
//                                            if (isValidFoodId) {
//                                                break;
//                                            } else {
//                                                System.out.print("Enter a valid food item id: ");
//                                            }
//                                        }
//
//                                        String foodItemName = foodItemController.getItemNameById(foodId);
//                                        String restaurantName = restaurantController.getRestaurantNameById(restaurantId);
//                                        int priceofItem = foodItemController.getPrice(foodItemName,foodId);
//                                        orderController.placeOrder(restaurantId , restaurantName , foodId , foodItemName , username  , email , priceofItem);
//                                        System.out.println("Order Placed🎉🎉🎉");
//                                    }
//                                    break;
//                                case 2:  //   view order history
//                                    Map<String, String> orderHistory = orderController.getOrderHistory(username, email);
//                                    if (orderHistory.isEmpty()) {
//                                        System.out.println("You had not placed any order");
//                                    } else {
//                                        System.out.println("History :-");
//                                        for (Map.Entry<String, String> entity : orderHistory.entrySet()) {
//                                            String orderItemName = entity.getValue();
//                                            String orderId = entity.getKey();
//                                            String foodId = orderController.getFoodIdBy(orderId);
//                                            int priceOfItem = foodItemController.getPrice(orderItemName, foodId);
//                                            System.out.println("Order Id : " + orderId + "   Order Item name : " + orderItemName + "   Price : " + priceOfItem);
//
//                                            List<String> orderHistoryDetailsList = orderController.orderHistoryDetails(orderItemName, orderId);
//
//                                            if (orderHistoryDetailsList != null) {
//                                                System.out.print("Restaurant Name : " + orderHistoryDetailsList.get(0) + "   Order Status : " + orderHistoryDetailsList.get(1));
//                                            } else {
//                                                System.out.println("Error: Insufficient order history details for Order Id: " + orderId);
//                                            }
//                                            System.out.println();
//                                        }
//                                    }
//                                    break;
//                                case 3:  //  view order status
//                                    orderHistory =  orderController.getOrderHistory(username , email);
//                                    if (orderHistory.isEmpty()){
//                                        System.out.println("You had not placed any order");
//                                    }
//                                    else {
//                                        System.out.println("Order status :-");
//                                        for (Map.Entry<String,String> entity : orderHistory.entrySet()){
//                                            String orderItemName = entity.getValue();
//                                            String orderId = entity.getKey();
//                                            String foodId = orderController.getFoodIdBy(orderId);
//                                            int priceOfItem = foodItemController.getPrice(orderItemName, foodId);
//                                            System.out.print("Order Id : " +  orderId + "   Order Item name : " + orderItemName + "   Price : " + priceOfItem + "    " );
//                                            List<String> orderHistoryDetailsList = orderController.orderHistoryDetails(orderItemName, orderId);
//                                            System.out.println("Order status : " + orderHistoryDetailsList.get(1));
//                                        }
//                                    }
//                                    break;
//                                case 4:
//                                    System.out.println("Logging out...");
//                                    break customerMenu;
//                                case 5:
//                                    System.out.println("Exiting application...");
//                                    return;
//                                case 6:  // Cancel order
//                                    Map<String, String> pendingOrderList = orderController.getPendingOrderList(); // getting food id and order id
//                                    if (!pendingOrderList.isEmpty()) {
//                                        System.out.println("1. Cancel order");
//                                        System.out.println("2. Back");
//                                        while (true) {
//                                            try {
//                                                choice = sc.nextInt();
//                                                sc.nextLine(); // Clear the buffer after reading an integer
//                                                if (choice == 1 || choice == 2) {
//                                                    break;
//                                                } else {
//                                                    System.out.println("Enter a valid choice: ");
//                                                }
//                                            } catch (InputMismatchException e) {
//                                                System.out.print("Enter a valid choice: ");
//                                                sc.next(); // Clear the invalid input
//                                            }
//                                        }
//
//                                        if (choice == 1) {
//                                            System.out.println("PENDING orders:");
//                                            for (Map.Entry<String, String> entry : pendingOrderList.entrySet()) {
//                                                String orderId = entry.getKey();
//                                                String foodId = entry.getValue();
//                                                String foodItemName = orderController.getFoodItemName(foodId, orderId);
//                                                int priceOfItem = foodItemController.getPrice(foodItemName, foodId);
//                                                System.out.println("Order ID: " + orderId + "   Order Item name: " + foodItemName + "   Price: " + priceOfItem);
//                                            }
//                                            System.out.print("Enter Order ID to cancel: ");
//                                            String orderIdToCancel = sc.nextLine();
//
//                                            if (pendingOrderList.containsKey(orderIdToCancel)) {
//                                                orderController.cancelOrder(orderIdToCancel);
//                                                System.out.println("Order " + orderIdToCancel + " has been cancelled.");
//                                            } else {
//                                                System.out.println("Invalid Order ID.");
//                                            }
//                                        } else {
//                                            System.out.println("Going back...");
//                                        }
//                                    } else {
//                                        System.out.println("No PENDING orders");
//                                    }
//                                    break;
//                                default:
//                                    System.out.println("Invalid option. Please select a valid option.");
//                                    break;
//                            }
//                        }
//                    } else {
//                        System.out.println("Invalid role detected.");
//                    }
//                }
//            } else if (choice == 3) {
//                System.out.println("Exiting application...");
//                return;
//            } else {
//                System.out.println("Invalid option. Please select a valid option.");
//            }
//        }
//    }
//}