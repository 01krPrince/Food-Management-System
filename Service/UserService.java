package Service;

import Repositories.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public String registerUser(String username, String email, String role, String password) {
        String checkUserByUsernameAndEmail = userRepository.checkUserByEmail(email);
        if(checkUserByUsernameAndEmail == null){

            UserRepository.registerUser(username , email , role , password);
            return "Registered";
        }
        else {
            return checkUserByUsernameAndEmail;
        }
    }

    public boolean loginUser(String email, String password) {
        return UserRepository.loginUser(email , password);
    }

    public String getRole(String email, String password) {
        return UserRepository.getRole(email , password);
    }
}