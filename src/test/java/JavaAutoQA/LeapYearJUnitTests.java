package JavaAutoQA;

import HomeWork2.LeapYear;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

/**
 * Created by akosatuchenko on 12/17/2014.
 */
public class LeapYearJUnitTests {
    Random rand = new Random();
    @BeforeClass
    public  static void DataSetUp(){
    }

    @Test
    public void TestLeapYearPositive(){
        Integer testInt = (rand.nextInt(1000) + 1)*400;
        LeapYear checkLeapYear= new LeapYear();
        Assert.assertTrue("Expecting Leap Year failed with year: " + testInt, checkLeapYear.isLeapYear(testInt));
    }

    @Test
    public void TestLeapYearNegative(){
        Integer testInt = (rand.nextInt(1000) + 1)/400;
        LeapYear checkLeapYear= new LeapYear();
        Assert.assertFalse("Expecting non Leap Year failed with year: " + testInt, checkLeapYear.isLeapYear(testInt));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void TestLeapYearZeroException(){
        LeapYear checkLeapYear= new LeapYear();
        exception.expect(RuntimeException.class);
        exception.expectMessage("I'm sorry, but 0 is not a valid year.");
        checkLeapYear.isLeapYear(0);
    }

    @Test
    public void TestLeapYearLessThanZeroException(){
        LeapYear checkLeapYear= new LeapYear();
        exception.expect(RuntimeException.class);
        exception.expectMessage("I'm sorry, but Year should be positive(e.g. > 0) is not a valid year.");
        checkLeapYear.isLeapYear(-1000);
    }

}
