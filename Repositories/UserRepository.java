package Repositories;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public static String getRole(String email, String password) {
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


    public static void registerUser(String username, String email, String role, String password) {
        User user = new User(username , email , role , password);
        userList.add(user);
    }

    public static boolean loginUser(String email, String password) {
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

}