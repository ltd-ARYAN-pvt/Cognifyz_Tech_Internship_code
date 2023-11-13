//Description: Create a program that checks the strength of a password. Prompt the user to input a password and analyze its strength based on certain criteria, such as length, presence of uppercase letters, lowercase letters, numbers, and special characters. Provide feedback on the password strength.

import java.util.Scanner;

public class L2_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();
        // Check password strength
        int strength = checkPasswordStrength(password);

        // Provide feedback on the password strength
        switch (strength) {
            case 1:
                System.out.println("Weak password. It should be at least 8 characters long.");
                break;
            case 2:
                System.out.println("Moderate password. It should include uppercase letters.");
                break;
            case 3:
                System.out.println("Strong password. It should include lowercase letters, numbers, and special characters.");
                break;
            case 4:
                System.out.println("Very strong password. Good job!");
                break;
        }
    }

    private static int checkPasswordStrength(String password) {
        int strength = 0;

        // Check length
        if (password.length() >= 8) {
            strength++;

            // Check for uppercase letters
            if (containsUppercase(password)) {
                strength++;

                // Check for lowercase letters, numbers, and special characters
                if (containsLowercase(password) && containsNumber(password) && containsSpecialCharacter(password)) {
                    strength++;
                }
            }
        }

        return strength;
    }

    private static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";
        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}