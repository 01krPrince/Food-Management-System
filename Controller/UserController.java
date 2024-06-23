package Controller;

import Service.UserService;

public class UserController {
    UserService userService = new UserService();

    public String registerUser(String username, String email, String role, String password) {
        return userService.registerUser(username , email , role , password);
    }

    public boolean loginUser(String email, String password) {
        return userService.loginUser( email,  password);
    }

    public String getRole(String email, String password) {
        return userService.getRole(email , password);
    }

    public boolean isEmailExist(String email) {
        return userService.isEmailExist(email);
    }

    public void saveAddressandPhoneOfCustomer(String username, String email, String phoneNo , String address) {
        userService.saveAddressandPhoneOfCustomer(username , email , phoneNo , address);
    }
}
