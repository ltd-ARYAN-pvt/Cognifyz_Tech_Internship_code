//Description: Build a program that generates a random password for the user. Prompt the user to enter the desired length of the password and specify whether it should include numbers, lowercase letters, uppercase letters, and special characters. Generate the password accordingly and display it to the user.

import java.util.Random;
import java.util.Scanner;

public class L1_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int passwordLength = sc.nextInt();

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = sc.next().equalsIgnoreCase("y");
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = sc.next().equalsIgnoreCase("y");
        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = sc.next().equalsIgnoreCase("y");
        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = sc.next().equalsIgnoreCase("y");

        sc.close();

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        StringBuilder charPool = new StringBuilder();
        if (includeNumbers) {
            charPool.append(numbers);
        }
        if (includeLowercase) {
            charPool.append(lowercase);
        }
        if (includeUppercase) {
            charPool.append(uppercase);
        }
        if (includeSpecialChars) {
            charPool.append(specialChars);
        }

        if (charPool.length() == 0) {
            System.out.println("You must select at least one character type.");
            return;
        }

        // Generate the random password
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(charPool.length());
            char randomChar = charPool.charAt(randomIndex);
            password.append(randomChar);
        }

        System.out.println("Your random password: " + password.toString());
    }
}