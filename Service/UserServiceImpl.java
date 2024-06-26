package Service;

import Repositories.UserRepositoryImpl;

public class UserServiceImpl {

    UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

    public String registerUser(String username, String email, String role, String password) {
        String checkUserByUsernameAndEmail = userRepositoryImpl.checkUserByEmail(email);
        if(checkUserByUsernameAndEmail == null){

            UserRepositoryImpl.registerUser(username , email , role , password);
            return "Registered";
        }
        else {
            return checkUserByUsernameAndEmail;
        }
    }

    public boolean loginUser(String email, String password) {
        return UserRepositoryImpl.loginUser(email , password);
    }

    public String getRole(String email, String password) {
        return UserRepositoryImpl.getRole(email , password);
    }

    public boolean isEmailExist(String email) {
        return userRepositoryImpl.isEmailExist(email);
    }

    public void saveAddressandPhoneOfCustomer(String username, String email, String phoneNo , String address) {
        userRepositoryImpl.saveAddressandPhoneOfCustomer(username , email , phoneNo , address);
    }

    public String getAddress(String username, String email) {
        return userRepositoryImpl.getAddress(username , email);
    }
}
