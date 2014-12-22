package JavaAutoQA;

import HomeWork2.CountChars;
import HomeWork2.LeapYear;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import tasks.CharacterDistributionAlgorithm;
import tasks.LeapYearAlgorithm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

/**
 * Created by Alexander on 17.12.2014.
 */
public class CharacterDistributionJUnitTests {
    Random r = new Random();
    private SecureRandom random = new SecureRandom();
    //below method started to generate multibyte chars, soooo skip it for now ;)
    private String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }

    @Parameterized.Parameter
    public CharacterDistributionAlgorithm countChars = new CountChars();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new CountChars()});
        return params;
    }

    @Test
    public void TestCharDistributionRandomString(){
        //String randomStr = randomString(20);
        String randomAlphaNumericString = new BigInteger(130, random).toString(32);
        Assert.assertTrue("Your Map is empty, bro.", countChars.getDistribution(randomAlphaNumericString).size() > 0);
    }

    @Test
    public void TestCharDistributionPositiveDataCorrectness(){
        String testStr = "ssAscAccA";
        for(Map.Entry<Character, Integer> element : countChars.getDistribution(testStr).entrySet())
            {
                Assert.assertTrue("Your char count is incorrect. Expected is 3 of each char. Actual is " + element.getValue(), element.getValue() == 3);
            }
    }

    @Test
    public void TestCharDistributionNegativeDataCorrectness(){
        String testStr = "~ss32123A..,.,scA1254~@#$%^&*ccA~";
        for(Map.Entry<Character, Integer> element : countChars.getDistribution(testStr).entrySet())
        {
            Assert.assertTrue("Your char count is incorrect. Expected is 3 of each char. Actual is " + element.getValue(), element.getValue() == 3);
        }
    }
}
