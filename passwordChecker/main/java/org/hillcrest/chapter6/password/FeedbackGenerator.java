package org.hillcrest.chapter6.password;

/**
 * Generates feedback about a passwords strength and what could be added to make it stronger.
 */
public class FeedbackGenerator {
    //utility class for generating feedback based on password

    /**
     * Generates feedback based on what criteria the password failed to meet.
     * @param password the password getting feedback on.
     * @return suggestions for increasing password strength
     */
    public static String generateFeedback(String password){
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
            for(int j = 0; j < upper.length(); j++){    if(sub.equals(upper.substring(j, j+1))){    hasUpper = true;}}
            for(int j = 0; j < lower.length(); j++){    if(sub.equals(lower.substring(j, j+1))){    hasLower = true;}}
            for(int j = 0; j < number.length(); j++){   if(sub.equals(number.substring(j, j+1))){   hasNum = true;} }
            for(int j = 0; j < special.length(); j++){  if(sub.equals(special.substring(j, j+1))){  hasSpecial = true;} }
        }
        String feedback = "Suggestions to improve your password: \n";
        if(password.length() < 8){  feedback += "- Increase the length to at least 8 characters.\n";}
        if(!hasUpper){  feedback += "- Add at least one uppercase letter.\n";}
        if(!hasLower){  feedback += "- Add at least one lowercase letter.\n";}
        if(!hasNum){    feedback += "- Add at least one number.\n";}
        if(!hasSpecial){feedback += "- Include at least one special character.\n";}
        if(hasUpper && hasLower && hasNum && hasSpecial && password.length() >=8){
            feedback = "That's a strong password.";
        }
        return feedback;
    }
}
