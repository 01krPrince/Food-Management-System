package Repositories.Impl;

import Repositories.UserRepository;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final List<User> userList = new ArrayList<>();

    public String getRole(String email, String password) {
        for (User user : userList){
            if(user.getEmail().equals(email)  &&  user.getPassword().equals(password)){
                return user.getRole();
            }
        }
        return "Role not found";
    }


    public String checkUserByEmail(String email) {
        for (User user : userList){
            if(user.getEmail().equals(email)){
                return "Email already exist!";
            }
        }
        return null;
    }


    public void registerUser(String username, String email, String role, String password) {
        User user = new User(username , email , role , password);
        userList.add(user);
    }

    public boolean loginUser(String email, String password) {
        for(User user : userList){
            if (user.getEmail().equals(email)  &&  user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean isEmailExist(String email) {
        for (User user : userList){
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public void saveAddressAndPhoneOfCustomer(String username, String email, String phoneNo , String address) {
        for (User user : userList){
            if (user.getUsername().equals(username)  &&  user.getEmail().equals(email)){
                user.setPhone(phoneNo);
                user.setAddress(address);
            }
        }
    }


    public String getAddress(String username, String email) {
        for (User user : userList){
            if (user.getUsername().equals(username)  &&  user.getEmail().equals(email)){
                return user.getAddress();
            }
        }
        return null;
    }

    public List<String> getProfile(String username, String password, String email) {
        List<String> userProfile = new ArrayList<>();
        for (User user : userList){
            if (user.getUsername().equals(username)  &&  user.getPassword().equals(password)  &&  user.getEmail().equals(email)){
                userProfile.add("Phone number :     "+user.getPhone());
                userProfile.add("Address :     "+user.getAddress());
            }
        }
        return userProfile;
    }
}