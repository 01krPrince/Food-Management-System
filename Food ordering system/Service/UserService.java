package Service;

public interface UserService {
    String registerUser(String username, String email, String role, String password);
    boolean loginUser(String email, String password);
    String getRole(String email, String password);
    boolean isEmailExist(String email);
    void saveAddressAndPhoneOfCustomer(String username, String email, String phoneNo, String address);
    String getAddress(String username, String email);
}