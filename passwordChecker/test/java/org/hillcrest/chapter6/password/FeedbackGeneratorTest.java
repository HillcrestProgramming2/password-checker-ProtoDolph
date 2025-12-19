package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackGeneratorTest {

    @Test
    public void testFeedbackAll(){
        String password = " ";
        String feedback = "Suggestions to improve your password: \n" +
                "- Increase the length to at least 8 characters.\n" +
                "- Add at least one uppercase letter.\n" +
                "- Add at least one lowercase letter.\n" +
                "- Add at least one number.\n" +
                "- Include at least one special character.\n";
        Assertions.assertEquals(feedback, FeedbackGenerator.generateFeedback(password));
    }

    @Test
    public void testFeedbackStrong(){
        String password = "P@$$w0rd67";
        String feedback = "That's a strong password.";
        Assertions.assertEquals(feedback, FeedbackGenerator.generateFeedback(password));
    }

}
