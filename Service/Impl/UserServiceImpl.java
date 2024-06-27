package Service.Impl;

import Repositories.Impl.UserRepositoryImpl;
import Service.UserService;

public class UserServiceImpl implements UserService {

    UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

    public String registerUser(String username, String email, String role, String password) {
        String checkUserByEmailResult = userRepositoryImpl.checkUserByEmail(email);
        if (checkUserByEmailResult != null) {
            return checkUserByEmailResult; // Email already exists
        } else {
            userRepositoryImpl.registerUser(username, email, role, password);
            return "Registered"; // Successfully registered
        }
    }


    public boolean loginUser(String email, String password) {
        return userRepositoryImpl.loginUser(email, password);
    }

    public String getRole(String email, String password) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        return userRepository.getRole(email, password);
    }

    public boolean isEmailExist(String email) {
        return userRepositoryImpl.isEmailExist(email);
    }

    public void saveAddressAndPhoneOfCustomer(String username, String email, String phoneNo , String address) {
        userRepositoryImpl.saveAddressAndPhoneOfCustomer(username , email , phoneNo , address);
    }

    public String getAddress(String username, String email) {
        return userRepositoryImpl.getAddress(username , email);
    }
}
