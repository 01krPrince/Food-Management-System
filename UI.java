import Controller.FoodItemController;
import Controller.OrderController;
import Controller.RestaurantController;
import Controller.UserController;


import java.util.*;

public class UI {

    public static void main(String[] args) {

        UserController userController = new UserController();
        RestaurantController restaurantController = new RestaurantController();
        FoodItemController foodItemController = new FoodItemController();
        OrderController orderController = new OrderController();

        HelperClass helperClass = new HelperClass();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Food Ordering System Application");

        int choice = 0;
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e + "👾");
                System.out.println("Try again");
                sc.nextLine(); // consume the leftover newline
                continue;
            }
            sc.nextLine(); // consume the leftover newline

            if (choice == 1) {
                String username;
                System.out.print("Enter your name: ");
                while (true) {
                    username = sc.nextLine();
                    if (HelperClass.validateName(username)) {
                        break;
                    }
                    System.out.println("Invalid name. Please enter a name without special characters:");
                }

                String email;
                System.out.print("Enter your email: ");
                while (true) {
                    email = sc.nextLine();
                    if (helperClass.validateEmail(email)) {
                        if (!userController.isEmailExist(email)) {
                            break;
                        }
                        System.out.println("This email is registered already.");
                        System.out.println("1. Enter a different email");
                        System.out.println("2. Go back to the main menu");
                        try {
                            choice = sc.nextInt();
                            sc.nextLine(); // consume the leftover newline
                        } catch (Exception e) {
                            System.out.println(e + "👾👾 Try again with a valid choice");
                            sc.nextLine(); // consume the leftover newline
                            continue;
                        }
                        if (choice == 1) {
                            continue;
                        } else if (choice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid option. Please select a valid option.");
                        }
                    } else {
                        System.out.println("Invalid email address. Please enter a valid email address:");
                    }
                }

                if (choice == 2) {
                    continue; // go back to the main menu
                }

                String role;
                System.out.print("Enter your role (owner or customer): ");
                while (true) {
                    role = sc.nextLine();
                    if (HelperClass.validateRole(role)) {
                        break;
                    }
                    System.out.println("Invalid role. Please choose 'owner' or 'customer':");
                }
                role = role.toLowerCase();

                String password;
                System.out.print("Enter a strong password (Example@123): ");
                while (true) {
                    String messageFromPassManager = HelperClass.validatePassword(password = sc.nextLine());
                    if (messageFromPassManager.equals("valid")) {
                        break;
                    }
                    System.out.println(messageFromPassManager);
                    System.out.print("Please enter a strong password (Example@123): ");
                }

//                System.out.println("Enter address not implemented yet");
//                String address = sc.nextLine();

                String registrationStatus = userController.registerUser(username, email, role, password);
                System.out.println(registrationStatus);
                System.out.println();

                if (role.equals("owner")) {
                    System.out.println("Enter your restaurant details:");
                    System.out.print("Restaurant name: ");
                    String restaurantName;
                    int isRestaurantExist;
                    while (true) {
                        restaurantName = sc.nextLine();
                        isRestaurantExist = restaurantController.isRestaurantExist(restaurantName, email);
                        if (isRestaurantExist == 0) {
                            break;
                        } else if (isRestaurantExist == 2) {
                            System.out.println("you have already registered this restaurant , Thanks you😊");
                            break;
                        }
                        else {
                            System.out.println("Restaurant name is already registered by a different user");
                            break;
                        }
                    }
                    if (isRestaurantExist == 2 || isRestaurantExist == 1){
                        continue;
                    }
                    System.out.print("Location: ");
                    String location = sc.nextLine();
                    System.out.print("Phone number: ");
                    String phone;
                    while (true) {
                        phone = sc.nextLine();
                        if (helperClass.validatePhone(phone)) {
                            if (!restaurantController.isphoneExist(phone)){
                                break;
                            }
                            System.out.println("Enter YOUR phone number please");
                            continue;
                        }
                        System.out.println("Enter a valid phone number");
                    }

                    int id = restaurantController.registerRestaurant(email, restaurantName, location, phone);
                    System.out.println("Id of your restaurant is: " + id);
                    System.out.println();
                }
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String username = sc.nextLine();
                System.out.print("Enter your email: ");
                String email = sc.nextLine();
                System.out.print("Enter your password: ");
                String password = sc.nextLine();
                boolean loginStatus = userController.loginUser(email, password);
                if (loginStatus) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Credentials not match in our entire repository, please register first!");
                }
                System.out.println();
                if (loginStatus) {
                    String role = userController.getRole(email, password);
                    if (role.equals("owner")) {
                        ownerMenu:
                        while (true) {
                            System.out.println("Owner Menu:");
                            System.out.println("1. Display your restaurant and its menu");
                            System.out.println("2. Add item to menu");
                            System.out.println("3. Remove item from menu");
                            System.out.println("9. Update Order Status");
                            System.out.println("4. Logout");
                            System.out.println("5. Exit");
                            System.out.println("6. Register restaurant");
                            System.out.println("7. Remove restaurant");
                            System.out.println("8. Back to previous menu");
                            try {
                                choice = sc.nextInt();
                            }
                            catch (Exception e){
                                System.out.println(e + "👾👾Try again");
                                System.out.println();
                                System.out.println();
                            }
                            sc.nextLine();

                            switch (choice) {
                                case 1: // Display your restaurant and its menu
                                    Map<String, String> restaurantList = restaurantController.getRestaurantListOf(email);
                                    if (restaurantList.isEmpty()) {
                                        System.out.println("You have not registered your restaurant yet.");
                                        System.out.println("1. Register restaurant");
                                        System.out.println("2. Logout");
                                        System.out.println("3. Exit");
                                        System.out.println("4. Back to previous menu");
                                        try {
                                            choice = sc.nextInt();
                                        } catch (Exception e) {
                                            System.out.println("Invalid input. Please enter a number from the menu.");
                                            sc.nextLine(); // consume the leftover newline
                                            continue;
                                        }
                                        sc.nextLine();

                                        switch (choice) {
                                            case 1:
                                                System.out.println("Enter restaurant details:");
                                                System.out.print("Restaurant name: ");
                                                String restaurantName = sc.nextLine();
                                                System.out.print("Location: ");
                                                String location = sc.nextLine();
                                                System.out.print("Phone number: ");
                                                String phone = sc.nextLine();
                                                int id = restaurantController.registerRestaurant(email, restaurantName, location, phone);
                                                System.out.println("Id of your restaurant is : " + id);
                                                System.out.println();
                                                break;
                                            case 2:
                                                System.out.println("Logging out...");
                                                System.out.println();
                                                break ownerMenu;
                                            case 3:
                                                System.out.println("Exiting application...");
                                                return;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Invalid option. Please select a valid option.");
                                        }
                                    } else {
                                        System.out.println("Your registered restaurants name & Id");
                                        for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
                                            String restaurantName = entry.getKey();
                                            String restaurantId = entry.getValue();
                                            System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
                                        }
                                        System.out.println("Enter restaurant Id to check their menu:");
                                        String restaurantId = sc.nextLine();
                                        Map<String, String> restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restaurantId);
                                        if (restaurantMenu.size() == 0) {
                                            System.out.println("There is no menu added yet");
                                            System.out.println("1. Add menu");
                                            System.out.println("2. Exit");
                                            System.out.println("3. Back to previous menu");

                                            choice = sc.nextInt();
                                            sc.nextLine();
                                            if (choice == 1) {
                                                System.out.print("Enter item to add: ");
                                                String itemToAdd = sc.nextLine();
                                                System.out.print("Enter price for " + itemToAdd + " : ");
                                                int price = sc.nextInt();
                                                foodItemController.addItem(itemToAdd, restaurantId , price);
                                                System.out.println("Item added successfully");
                                            } else if (choice == 2) {
                                                break ownerMenu;
                                            } else if (choice == 3) {
                                                break;
                                            } else {
                                                System.out.println("Invalid option. Please select a valid option.");
                                            }
                                        } else {
                                            System.out.println("Menu");
                                            for (Map.Entry<String, String> entry : restaurantMenu.entrySet()) {
                                                String itemName = entry.getKey();
                                                String itemId = entry.getValue();
                                                System.out.println("Item name: " + itemName + "  Id: " + itemId);
                                            }
                                        }
                                    }
                                    break;
                                case 2: // Add item in menu
                                    restaurantList = restaurantController.getRestaurantListOf(email);
                                    System.out.println("Your registered restaurants name & Id");
                                    for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
                                        String restaurantName = entry.getKey();
                                        String restaurantId = entry.getValue();
                                        System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
                                    }
                                    System.out.println("Enter restaurant Id to add item in their menu:");
                                    String restaurantId = sc.nextLine();
                                    System.out.print("Enter item to add: ");
                                    String itemToAdd = sc.nextLine();
                                    System.out.print("Enter price for " + itemToAdd + " : ");
                                    int price = sc.nextInt();
                                    foodItemController.addItem(itemToAdd, restaurantId , price);
                                    System.out.println("Item added successfully");
                                    break;
                                case 3:  // Remove an item from the menu
                                    Map<String , String>  restaurantListt = new HashMap<>();
                                    Map<String , String>  restaurantMenu = new HashMap<>();

                                    restaurantListt = restaurantController.getRestaurantListOf(email);
                                    for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
                                        String restaurantName = entry.getKey();
                                        String restauranttId = entry.getValue();
                                        System.out.println("Restaurant Name : " + restaurantName + ", Id : " + restauranttId);

                                        restaurantMenu = foodItemController.getRestaurantMenuByRestaurantId(restauranttId);
                                        for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
                                            String itemName = entry1.getKey();
                                            String itemId = entry1.getValue();
                                            System.out.println("Item Name : " + itemName + ", Id : " + itemId);
                                        }
                                    }

                                    String id1;
                                    while (true) {
                                        boolean found = false;
                                        System.out.println("Choose Restaurant id to remove their food item from menu: ");
                                        id1 = sc.nextLine();
                                        for (Map.Entry<String, String> entry : restaurantListt.entrySet()) {
                                            if (entry.getValue().equals(id1)) {
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found) {
                                            break;
                                        } else {
                                            System.out.println("Invalid Restaurant id. Try again.");
                                        }
                                    }

                                    if (!foodItemController.getRestaurantMenuByRestaurantId(id1).isEmpty()){
                                        String id2;
                                        while (true){
                                            boolean found = false;
                                            System.out.println("Choose item id to remove from menu : ");
                                            id2 = sc.nextLine();
                                            for (Map.Entry<String , String> entry1 : restaurantMenu.entrySet()){
                                                if (entry1.getValue().equals(id2)){
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found){
                                                break;
                                            }
                                            else {
                                                System.out.println("item removed.");
                                                break;
                                            }
                                        }
                                        foodItemController.removeItem(id1 , id2);
                                    }

                                    else {
                                        System.out.println("No item available for this restaurant yet");
                                    }

                                    break;


                                case 4:  // Log out...
                                    System.out.println("Logging out...");
                                    break ownerMenu;
                                case 5:  // Quit from application
                                    System.out.println("Exiting application...");
                                    return;
                                case 6:
                                    System.out.println("Enter restaurant details");
                                    System.out.print("Restaurant name: ");
                                    String restaurantName;
                                    int isRestaurantExist;
                                    while (true) {
                                        restaurantName = sc.nextLine();
                                        isRestaurantExist = restaurantController.isRestaurantExist(restaurantName, email);
                                        if (isRestaurantExist == 0) {
                                            break;
                                        } else if (isRestaurantExist == 2) {
                                            System.out.println("you have already registered this restaurant , Thanks you😊");
                                            break;
                                        }
                                        else {
                                            System.out.println("Restaurant name is already registered by a different user");
                                            break;
                                        }
                                    }
                                    if (isRestaurantExist == 2 || isRestaurantExist == 1){
                                        break;
                                    }
                                    System.out.print("Location: ");
                                    String location = sc.nextLine();
                                    System.out.print("Phone number: ");
                                    String phone = sc.nextLine();
                                    int registrationStatus = restaurantController.registerRestaurant(email, restaurantName, location, phone);
                                    System.out.println(registrationStatus);
                                    System.out.println();
                                    break;
                                case 7:
                                    System.out.println("Are you sure you want to discontinue a restaurant?");
                                    System.out.println("true or false");
                                    if (sc.nextLine().equals("true")) {
                                        System.out.println("Select restaurant to discontinue");
                                        Map<String, String> restaurantList3 = restaurantController.getRestaurantListOf(email);
                                        System.out.println("Your restaurants:");
                                        int i = 1;
                                        for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
                                            restaurantName = entry.getKey();
                                            System.out.println(i + ". " + restaurantName);
                                            i++;
                                        }
                                        System.out.print("Enter the number of the restaurant: ");
                                        while (true) {
                                            int restaurantChoice = sc.nextInt();
                                            sc.nextLine(); // consume the leftover newline
                                            if (restaurantChoice > 0 && restaurantChoice <= restaurantList3.size()) {
                                                String status = restaurantController.discontinue(restaurantChoice);
                                                System.out.println(status);
                                                System.out.println();
                                                break;
                                            }
                                            System.out.println("Enter correct option from 1 to " + restaurantList3.size());
                                        }
                                    }
                                    break;
                                case 8:
                                    break ownerMenu;

                                case 9 :  //  Checking Order Request   &    Updating Order Status
                                    List<String> checkingOrderRequest = new ArrayList<>();
                                    Map<String, String> restaurantList3 = restaurantController.getRestaurantListOf(email);
                                    for (Map.Entry<String, String> entry : restaurantList3.entrySet()) {
                                        restaurantId = entry.getValue();
                                        checkingOrderRequest = orderController.checkingOrderRequest(restaurantId);
                                        for (String orderId : checkingOrderRequest){
                                            System.out.print("Order id "+orderId);
                                            System.out.println(" is "+orderController.deleverOrder(orderId));
                                        }
                                    }

                                default:
                                    System.out.println("Invalid option. Please select a valid option.");
                            }
                        }
                    }
































                    else if (role.equals("customer")) {

                        System.out.print("Enter your Address : ");
                        String address = sc.nextLine();
                        System.out.print("Enter phone number : ");
                        String phoneNo = sc.nextLine();
                        userController.saveAddressandPhoneOfCustomer(username , email , phoneNo , address);

                        customerMenu:
                        while (true) {
                            System.out.println("Customer Menu:");
                            System.out.println("1. Place an order");
                            System.out.println("2. View order history");
                            System.out.println("6. View order status");
                            System.out.println("3. Logout");
                            System.out.println("4. Exit");
                            System.out.println("5. Back to previous menu");
                            try {
                                choice = sc.nextInt();
                            }
                            catch (Exception e){
                                System.out.println(e + "👾👾Try again");
                                System.out.println();
                                System.out.println();
                            }
                            sc.nextLine();

                            switch (choice) {
                                case 1:  //  Place an order
                                    Map<String, String> restaurantList = restaurantController.getAllAvailableRestaurantList();
                                    if (restaurantList.size() == 0){
                                        System.out.println("Now, There is no restaurant available");
                                    }
                                    else {
                                        System.out.println("Available Restaurants List and their menu");
                                        for (Map.Entry<String, String> entry : restaurantList.entrySet()) {
                                            String restaurantId = entry.getValue();
                                            String restaurantName = entry.getKey();
                                            System.out.println("Restaurant name : " +  restaurantName + "    ID : " + restaurantId);
                                            Map<String , String> menuOfRestaurant = foodItemController.getRestaurantMenuOf(restaurantName);
                                            for (Map.Entry<String , String> entry1 : menuOfRestaurant.entrySet()) {
                                                String menuId = entry1.getValue();
                                                String menuItem = entry1.getKey();
                                                System.out.println("Menu Item : " +  menuItem + "    ID : " + menuId);
                                                int priceOfItem = foodItemController.getPrice(menuItem , menuId);
                                            }
                                        }
                                        System.out.println("Enter restaurant id and item id to place your order");
                                        String restaurantId = sc.nextLine();
                                        String itemId = sc.nextLine();
                                        String itemName = foodItemController.getItemNameById(itemId);
                                        orderController.placeOrder(restaurantId , itemId , itemName , username , address , email);
                                        System.out.println("Order Placed🎉🎉🎉");
                                    }
                                    break;
                                case 2:  // Code to view order history
                                    Map<String , String> orderHistory =  orderController.getOrderHistory(username , email);
                                    for (Map.Entry<String,String> entity : orderHistory.entrySet()){
                                        String orderId = entity.getValue();
                                        String orderItem = entity.getKey();
                                        System.out.println("Order Item : " +  orderItem + "   Order ID : " + orderId);
                                        List<String> orderHistoryDetailsList = orderController.orderHistoryDetails(orderItem , orderId);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Logging out...");
                                    break customerMenu;
                                case 4:
                                    System.out.println("Exiting application...");
                                    return;
                                case 5:
                                    break customerMenu;
                                default:
                                    System.out.println("Invalid option. Please select a valid option.");
                            }
                        }
                    } else {
                        System.out.println("Invalid role detected.");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting application...");
                return;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}