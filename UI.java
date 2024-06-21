import Controller.FoodItemController;
import Controller.RestaurantController;
import Controller.UserController;

import java.util.Map;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        UserController userController = new UserController();
        RestaurantController restaurantController = new RestaurantController();
        FoodItemController foodItemController = new FoodItemController();

        HelperClass helperClass = new HelperClass();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Food Ordering System Application");

        int choice = 0;
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            choice = sc.nextInt();
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
                    if (HelperClass.validateEmail(email)) {
                        break;
                    }
                    System.out.println("Invalid email address. Please enter a valid email address:");
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

                String registrationStatus = userController.registerUser(username, email, role, password);
                System.out.println(registrationStatus);
                System.out.println();

                if (role.equals("owner")) {
                    System.out.println("Enter your restaurant details:");
                    System.out.print("Restaurant name: ");
                    String restaurantName = sc.nextLine();
                    System.out.print("Location: ");
                    String location = sc.nextLine();
                    System.out.print("Phone number: ");
                    String phone;
                    while (true) {
                        phone = sc.nextLine();
                        if (helperClass.validatePhone(phone)) {
                            break;
                        }
                        System.out.println("Enter a valid phone number");
                    }

                    int id = restaurantController.registerRestaurant(email, restaurantName, location, phone);
                    System.out.println("Id of your restaurant is : " + id);
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
                            System.out.println("4. Logout");
                            System.out.println("5. Exit");
                            System.out.println("6. Register restaurant");
                            System.out.println("7. Remove restaurant from application");
                            System.out.println("8. Back to previous menu");
                            choice = sc.nextInt();
                            sc.nextLine(); // consume the leftover newline

                            switch (choice) {
                                case 1:
                                    Map<String, String> restaurantList = restaurantController.getRestaurantListOf(email);
                                    if (restaurantList.size() == 0) {
                                        System.out.println("You have not registered your restaurant yet.");
                                        System.out.println("1. Register restaurant");
                                        System.out.println("2. Logout");
                                        System.out.println("3. Exit");
                                        System.out.println("4. Back to previous menu");
                                        choice = sc.nextInt();
                                        sc.nextLine(); // consume the leftover newline

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
                                        Map<String, String> restaurantMenu = foodItemController.getRestaurantMenuOf(restaurantId);
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
                                                foodItemController.addItem(itemToAdd, restaurantId);
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
                                case 2:
                                    Map<String, String> restaurantList2 = restaurantController.getRestaurantListOf(email);
                                    System.out.println("Your registered restaurants name & Id");
                                    for (Map.Entry<String, String> entry : restaurantList2.entrySet()) {
                                        String restaurantName = entry.getKey();
                                        String restaurantId = entry.getValue();
                                        System.out.println("Restaurant name: " + restaurantName + "  Id: " + restaurantId);
                                    }
                                    System.out.println("Enter restaurant Id to add more items in menu:");
                                    String restaurantId = sc.nextLine();
                                    System.out.print("Enter item to add: ");
                                    String itemToAdd = sc.nextLine();
                                    foodItemController.addItem(itemToAdd, restaurantId);
                                    System.out.println("Item added successfully");
                                    break;
                                case 3:
                                    // Code to remove an item from the menu
                                    break;
                                case 4:
                                    System.out.println("Logging out...");
                                    break ownerMenu;
                                case 5:
                                    System.out.println("Exiting application...");
                                    return;
                                case 6:
                                    System.out.println("Enter restaurant details:");
                                    System.out.print("Restaurant name: ");
                                    String restaurantName = sc.nextLine();
                                    System.out.print("Location: ");
                                    String location = sc.nextLine();
                                    System.out.print("Phone number: ");
                                    String phone = sc.nextLine();
                                    // String registrationStatus = restaurantController.registerRestaurant(email, restaurantName, location, phone);
                                    // System.out.println(registrationStatus);
                                    System.out.println();
                                    break;
                                case 7:
                                    System.out.println("Are you sure you want to discontinue your services?");
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
                                default:
                                    System.out.println("Invalid option. Please select a valid option.");
                            }
                        }
                    } else if (role.equals("customer")) {
                        customerMenu:
                        while (true) {
                            System.out.println("Customer Menu:");
                            System.out.println("1. Place an order");
                            System.out.println("2. View order history");
                            System.out.println("3. Logout");
                            System.out.println("4. Exit");
                            System.out.println("5. Back to previous menu");
                            choice = sc.nextInt();
                            sc.nextLine(); // consume the leftover newline

                            switch (choice) {
                                case 1:
                                    // Code to display list of restaurants and place an order
                                    break;
                                case 2:
                                    // Code to view order history
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
                } else {
                    System.out.println("Login failed. Please try again.");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using the Food Ordering System Application. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
