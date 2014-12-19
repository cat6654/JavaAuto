package JavaAutoQA;

import HomeWork2.LeapYear;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tasks.LeapYearAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by akosatuchenko on 12/17/2014.
 */
@RunWith(Parameterized.class)
public class LeapYearJUnitTests {
    Random rand = new Random();

    @Parameterized.Parameter
    public LeapYearAlgorithm leapYear = new LeapYear();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new LeapYear()});
        return params;
    }

    @BeforeClass
    public  static void DataSetUp(){
    }

    @Test
    public void TestLeapYearPositive(){
        Integer testInt = (rand.nextInt(1000) + 1)*400;
        Assert.assertTrue("Expecting Leap Year failed with year: " + testInt, leapYear.isLeapYear(testInt));
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
