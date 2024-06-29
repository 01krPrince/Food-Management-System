
                                             Food Order Management System

Overview:-

This project entails the development of a comprehensive food order management system catering to multiple restaurants. The system enables users to place orders, view their profiles, and track order status. Restaurant owners can create, update, and delete restaurants, add menu items, and manage orders.

                                                   **Requirements**

1. User Management: Users can register, log in, and access their profiles, with roles defined as customers or restaurant owners.
2. Restaurant Management: Restaurant owners can create, update, and delete restaurants, with associated food items.
3. Food Item Management: Restaurant owners can add, update, and delete food items, including details such as name, description, price, and availability.
4. Order Management: Customers can place orders, view order history, and track status, while restaurant owners can update order status.

                                                ****Project Structure****

The project comprises four main components:

1. UserService: Handles user-related operations, including registration, login, and profile retrieval.
2. RestaurantService: Manages restaurant operations, including creation, updating, and deletion of restaurants and food items.
3. FoodItemService: Manages food item operations, including addition, updating, and deletion.
4. OrderService: Manages order operations, including placement, order history, and status updates.

Usage

1. User Registration and Login: Register as a customer or restaurant owner and log in to access profiles.
2. Restaurant Management: Create, update, or delete restaurants and manage food items (restaurant owners).
3. Food Item Management: Add, update, or delete food items (restaurant owners).
4. Order Management: Place orders (customers), view order history (customers), and update order status (restaurant owners).



Owner Functionalities:

1.  View Profile: Restaurant owners can view their profile information.

2.  Display Your Restaurant and Its Menu: Owners can showcase their restaurant details, including the menu items available.

3.  Add Item to Menu: Owners can add new food items to their restaurant's menu.

4.  Remove Item from Menu: Owners can remove existing food items from the menu.

5.  Update Food Item Price: Owners have the capability to modify the prices of food items listed on the menu.

6.  Update Order Status: Owners can update the status of customer orders, such as marking them as preparing, ready for pickup, or delivered.

7.  Logout: Owners can securely log out of their account to protect their data.

8.  Exit: Option for owners to exit the system when finished using it.

9.  Register Restaurant: New restaurant owners can register their establishments within the system.

10. Update Restaurant: Owners can update their restaurant details, such as contact information or operating hours.

11. Remove Restaurant: Owners have the ability to delete their restaurant profile from the system.

12. Back to Login Page: Provides a convenient way for owners to return to the login interface.

**Customer Functionalities:

1.  View Profile: Customers can access and view their profile details within the system.

2.  Place an Order: Customers can place food orders directly from the restaurant's menu.

3.  View Order History: Customers can review their past orders to track their dining history.

4.  View Order Status: Customers can monitor the current status of their orders in real-time.

5.  Cancel Order: Customers have the option to cancel an order if necessary.

6.  Logout: Customers can securely log out of their account for privacy and security reasons.

**Models

1. User: Represents users with unique identifiers, usernames, passwords, email addresses, and roles.
2. Restaurant: Represents restaurants with unique identifiers, owner IDs, names, addresses, phone numbers, and associated food items.
3. FoodItem: Represents food items with unique identifiers, restaurant IDs, names, descriptions, prices, and availability status.
4. Order: Represents orders with unique identifiers, customer IDs, restaurant IDs, food items, total prices, and status.

**Repositories

1. UserRepository: Provides methods for finding users by username or email.
2. RestaurantRepository: Provides methods for finding restaurants by owner ID.
3. FoodItemRepository: Provides methods for finding food items by restaurant ID.
4. OrderRepository: Provides methods for finding orders by customer ID or restaurant ID.

**Services

1. UserService: Provides methods for registering, logging in, and retrieving user profiles.
2. RestaurantService: Provides methods for creating, updating, and deleting restaurants and associated food items.
3. FoodItemService: Provides methods for adding, updating, and deleting food items.
4. OrderService: Provides methods for placing orders, retrieving orders by customer or restaurant ID, and updating order status.

**Controllers

1. UserController: Handles user registration, login, and profile retrieval.
2. RestaurantController: Handles restaurant creation, updating, and deletion, as well as food item management.
3. FoodItemController: Handles food item addition, updating, and deletion.
4. OrderController: Handles order placement, retrieval, and status updates.

This system aims to provide a streamlined and efficient food order management experience for both customers and restaurant owners.