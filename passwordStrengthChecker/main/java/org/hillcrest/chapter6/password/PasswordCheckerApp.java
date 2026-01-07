package org.hillcrest.chapter6.password;

import java.util.Scanner;

/**
 * Application that takes a password and evaluates its strength.
 */
public class PasswordCheckerApp {
    //main method goes here
    //prompt user for password
    //Check strength
    //Provide user feedback based on the strength
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the password strength checker!");
        System.out.print("Enter a password: ");
        String password = in.nextLine();
        System.out.println(FeedbackGenerator.generateFeedback(password));
    }
}
