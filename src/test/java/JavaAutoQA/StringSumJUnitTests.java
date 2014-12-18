package JavaAutoQA;

import HomeWork2.JavaRegex;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by akosatuchenko on 12/17/2014.
 */
public class StringSumJUnitTests {
    private SecureRandom random = new SecureRandom();

    @Test
    public void TestStringSumRandomAplaNumericString(){
        JavaRegex jRegex = new JavaRegex();
        String randomAlphaNumericString = new BigInteger(130, random).toString(32);
        randomAlphaNumericString +=1;
        Assert.assertTrue("Something is wrong, bro. Actual is " + jRegex.getSumFromString(randomAlphaNumericString),jRegex.getSumFromString(randomAlphaNumericString) > 1);
    }

    @Test
    public void TestStringSumDataCorrectness(){
        JavaRegex jRegex = new JavaRegex();
        String testString = "a1.2bcde5ghergb9kljk10j";
        Assert.assertTrue("Sum is incorrect. Expected sum is 25.2 ; Actual is " + jRegex.getSumFromString(testString), jRegex.getSumFromString(testString) == 25.2);
    }


}
