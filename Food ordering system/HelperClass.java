import java.util.Random;

public class HelperClass {

    public static boolean validateNameWithoutSpecialCharacters(String username) {
        return username.matches("[a-zA-Z]+( [a-zA-Z]+)*"); // Allows alphabetic characters and spaces but not only spaces
    }

    public static String generateRandomNumberId(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        return sb.toString();
    }

    public static boolean validateEmail(String email) {
        // Regular expression for validating an email address
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        // Check if the email matches the regular expression
        return email.matches(emailRegex);
    }

    public static boolean validateRole(String role) {
        if (role.toLowerCase().equals("owner")  ||  role.toLowerCase().equals("customer")){
            return true;
        }
        return false;
    }

    public static String validatePassword(String password) {
        if (password.length() < 8) {
            return "Password must be at least 8 characters long";
        }

        if (!Character.isUpperCase(password.charAt(0))) {
            return "First character must be uppercase";
        }

        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        if (!hasLowercase) {
            return "Password must contain at least one lowercase letter";
        }

        if (!hasDigit) {
            return "Password must contain at least one digit";
        }

        if (!hasSpecialChar) {
            return "Password must contain at least one special character";
        }

        return "valid";
    }

    public static boolean validatePhone(String phone) {
        if (phone.length() == 10) {
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean restaurantNameValidate(String restaurantName) {
        if (!restaurantName.isEmpty()){
            return true;
        }
        return false;
    }
}
