package JavaAutoQA;

import HomeWork2.CountChars;
import HomeWork2.JavaRegex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import tasks.CharacterDistributionAlgorithm;
import tasks.StringSumAlgorithm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by akosatuchenko on 12/17/2014.
 */
public class StringSumJUnitTests {
    private SecureRandom random = new SecureRandom();

    @Parameterized.Parameter
    public StringSumAlgorithm jRegex = new JavaRegex();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new JavaRegex()});
        return params;
    }


    @Test
    public void TestStringSumRandomAplaNumericString(){
        String randomAlphaNumericString = new BigInteger(130, random).toString(32);
        randomAlphaNumericString +=1;
        Assert.assertTrue("Something is wrong, bro. Actual is " + jRegex.getSumFromString(randomAlphaNumericString),jRegex.getSumFromString(randomAlphaNumericString) > 1);
    }

    @Test
    public void TestStringSumDataCorrectness(){
        String testString = "a1.2bcde5ghergb9kljk10j";
        Assert.assertTrue("Sum is incorrect. Expected sum is 25.2 ; Actual is " + jRegex.getSumFromString(testString), jRegex.getSumFromString(testString) == 25.2);
    }


}
