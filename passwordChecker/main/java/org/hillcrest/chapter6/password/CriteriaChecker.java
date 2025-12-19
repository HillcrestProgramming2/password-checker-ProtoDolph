package org.hillcrest.chapter6.password;

/**
 * this is a utility class meant to check the strength of a password by testing it for certain criteria.
 * And calculating the strength by seeing how much criteria it met.
 */
public class CriteriaChecker {

    //utility class

    /**
     * Checks this password with the password criteria and returns a number of how many criteria the
     * password met. The following criteria are:
     * At least 8 characters in length.
     * contains 1 uppercase letter.
     * contains 1 lowercase letter.
     * contains 1 number.
     * contains 1 special character.
     * @param password the password
     * @return an int value of how many criteria were met.
     */
    public static int evaluateCriteria(String password){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";
        String special = "!@#$%^&*()_+-=`{}[]|\\:;\"',./?<>";
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNum = false;
        boolean hasSpecial = false;
        for(int i = 0; i < password.length(); i++){
            String sub = password.substring(i,i+1);
            for(int j = 0; j < upper.length(); j++){
                if(sub.equals(upper.substring(j, j+1))){    hasUpper = true;}
            }
            for(int j = 0; j < lower.length(); j++){
                if(sub.equals(lower.substring(j, j+1))){    hasLower = true;}
            }
            for(int j = 0; j < number.length(); j++){
                if(sub.equals(number.substring(j, j+1))){   hasNum = true;}
            }
            for(int j = 0; j < special.length(); j++){
                if(sub.equals(special.substring(j, j+1))){  hasSpecial = true;}
            }
        }
        int score = 0;
        if(hasUpper){ score++;}
        if(hasLower){ score++;}
        if(hasNum){ score++;}
        if(hasSpecial){ score++;}
        if(password.length() >= 8){ score++;}
        return score;
    }

    /**
     * Returns a String representation of the password's strength based on its score;
     * Strong if score is 4-5;
     * Moderate if score is 2-3.
     * Weak if score is 0-1;
     * @param score the strength score of the password
     * @return String: The strength of the password;
     */
    public static String determineStrength(int score){
        if(score >= 4){
            return "Strong";
        } else if (score >= 2){
            return "Moderate";
        } else {
            return "Weak";
        }
    }

}
