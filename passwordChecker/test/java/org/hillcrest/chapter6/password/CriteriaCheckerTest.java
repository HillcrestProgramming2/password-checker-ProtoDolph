package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriteriaCheckerTest {

    @Test
    public void testStrongPassword(){
        String password = "Pa$$w0rD67";
        Assertions.assertEquals(5, CriteriaChecker.evaluateCriteria(password));
    }

    @Test
    public void testPasswordMissingOne(){
        //length
        String password = "5H()rt";
        Assertions.assertEquals(4, CriteriaChecker.evaluateCriteria(password));
        //upper
        password = "password$5";
        Assertions.assertEquals(4, CriteriaChecker.evaluateCriteria(password));
        //lower
        password = "P@$$W0RD5";
        Assertions.assertEquals(4, CriteriaChecker.evaluateCriteria(password));
        //number
        password = "Pa$$words";
        Assertions.assertEquals(4, CriteriaChecker.evaluateCriteria(password));
        //special characters
        password = "Passwords67";
        Assertions.assertEquals(4, CriteriaChecker.evaluateCriteria(password));
    }

    @Test
    public void testMissingAll(){
        String password = " ";
        Assertions.assertEquals(0, CriteriaChecker.evaluateCriteria(password));
    }

    @Test
    public void testDetermineStrengthStrong(){
        String password = "Pa$$w0rD67";
        int score = CriteriaChecker.evaluateCriteria(password);
        Assertions.assertEquals("Strong", CriteriaChecker.determineStrength(score));
    }

    @Test
    public void testDetermineStrengthModerate(){
        String password = "Password";
        int score = CriteriaChecker.evaluateCriteria(password);
        Assertions.assertEquals("Moderate", CriteriaChecker.determineStrength(score));
    }
    @Test
    public void testDetermineStrengthWeak(){
        String password = "pasword";
        int score = CriteriaChecker.evaluateCriteria(password);
        Assertions.assertEquals("Weak", CriteriaChecker.determineStrength(score));
    }


}
