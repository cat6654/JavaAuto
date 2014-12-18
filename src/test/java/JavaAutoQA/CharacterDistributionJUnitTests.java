package JavaAutoQA;

import HomeWork2.CountChars;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

/**
 * Created by Alexander on 17.12.2014.
 */
public class CharacterDistributionJUnitTests {
    Random r = new Random();
    private String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void TestCharDistributionRandomString(){
        String randomStr = randomString(20);
        CountChars countChars = new CountChars();
        Assert.assertTrue("Your Map is empty, bro.", countChars.getDistribution(randomStr).size() > 0);
    }

    @Test
    public void TestCharDistributionPositiveDataCorrectness(){
        String testStr = "ssAscAccA";
        CountChars countChars = new CountChars();
        for(Map.Entry<Character, Integer> element : countChars.getDistribution(testStr).entrySet())
            {
                Assert.assertTrue("Your char count is incorrect. Expected is 3 of each char. Actual is " + element.getValue(), element.getValue() == 3);
            }
    }

    @Test
    public void TestCharDistributionNegativeDataCorrectness(){
        String testStr = "~ss32123A..,.,scA1254~@#$%^&*ccA~";
        CountChars countChars = new CountChars();
        for(Map.Entry<Character, Integer> element : countChars.getDistribution(testStr).entrySet())
        {
            Assert.assertTrue("Your char count is incorrect. Expected is 3 of each char. Actual is " + element.getValue(), element.getValue() == 3);
        }
    }
}
