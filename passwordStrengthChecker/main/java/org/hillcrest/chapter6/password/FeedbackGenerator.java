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
        String feedback = "Password Strength: ";
        int score = CriteriaChecker.evaluateCriteria(password);
        feedback += CriteriaChecker.determineStrength(score);
        feedback += " (" + score + "/5)\n";
        if(score < 5) {
            String special = "!@#$%^&*()-+=";
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasNum = false;
            boolean hasSpecial = false;
            for(int i = 0; i < password.length(); i++){
                char ch = password.charAt(i);
                if(Character.isUpperCase(ch)){
                    hasUpper = true;
                }
                else if(Character.isLowerCase(ch)){
                    hasLower = true;
                }
                else if(Character.isDigit(ch)){
                    hasNum = true;
                }
                else if(special.contains(password.substring(i,i+1))){
                    hasSpecial = true;
                }
            }
            feedback += "Suggestions to improve your password: \n";
            if (password.length() < 8) {
                feedback += "- Increase the length to at least 8 characters.\n";
            }
            if (!hasUpper) {
                feedback += "- Add at least one uppercase letter.\n";
            }
            if (!hasLower) {
                feedback += "- Add at least one lowercase letter.\n";
            }
            if (!hasNum) {
                feedback += "- Add at least one number.\n";
            }
            if (!hasSpecial) {
                feedback += "- Include at least one special character.\n";
            }
        } else {
            feedback += "That's a strong password.";
        }
        return feedback;
    }
}
