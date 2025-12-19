package org.hillcrest.chapter6.password;

import java.util.Scanner;

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
        int score = CriteriaChecker.evaluateCriteria(password);
        System.out.printf("Password Strength: %s (%d/5)",CriteriaChecker.determineStrength(score), score);
        System.out.println();
        System.out.println(FeedbackGenerator.generateFeedback(password));
    }
}
