package Repositories;

public interface UserRepository {
    String getRole(String email, String password);
    String checkUserByEmail(String email);
    void registerUser(String username, String email, String role, String password);
    boolean loginUser(String email, String password);
    boolean isEmailExist(String email);
    void saveAddressAndPhoneOfCustomer(String username, String email, String phoneNo, String address);
    String getAddress(String username, String email);
}
