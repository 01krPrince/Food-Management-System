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
}
