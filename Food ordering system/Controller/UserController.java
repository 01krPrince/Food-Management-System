package Controller;

import Service.Impl.UserServiceImpl;

import java.util.List;

public class UserController {
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    public String registerUser(String username, String email, String role, String password) {
        return userServiceImpl.registerUser(username , email , role , password);
    }

    public boolean loginUser(String email, String password) {
        return userServiceImpl.loginUser( email,  password);
    }

    public String getRole(String email, String password) {
        return userServiceImpl.getRole(email , password);
    }

    public boolean isEmailExist(String email) {
        return userServiceImpl.isEmailExist(email);
    }

    public void saveAddressandPhoneOfCustomer(String username, String email, String phoneNo , String address) {
        userServiceImpl.saveAddressAndPhoneOfCustomer(username , email , phoneNo , address);
    }

    public String getAddress(String username, String email) {
        return userServiceImpl.getAddress(username , email);
    }

    public List<String> getProfile(String username, String password, String email) {
        return userServiceImpl.getProfile(username,password,email);
    }
}
