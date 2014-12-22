package JavaAutoQA;

import HomeWork2.JavaRegex;
import HomeWork2.SubSequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import tasks.StringSumAlgorithm;
import tasks.SubSequenceAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexander on 18.12.2014.
 */
public class SubSequenceJUnitTests {


    @Parameterized.Parameter
    public SubSequenceAlgorithm sub = new SubSequence();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new SubSequence()});
        return params;
    }

    @Test
    public void TestSubSequencePositive(){
        List<Integer> listOne = new ArrayList<Integer>();
        List<Integer> listTwo = new ArrayList<Integer>();
        listOne.add(1);
        listOne.add(100);
        listOne.add(3);
        listOne.add(10);
        listOne.add(500);
        listOne.add(100500);

        listTwo.add(3);
        listTwo.add(500);

        Assert.assertTrue("List two is subSequence of list one. " , sub.isSubSequence(listOne, listTwo));
    }

    @Test
    public void TestSubSequenceNegative(){
        List<Integer> listOne = new ArrayList<Integer>();
        List<Integer> listTwo = new ArrayList<Integer>();
        listOne.add(1);
        listOne.add(100);
        listOne.add(3);
        listOne.add(10);
        listOne.add(500);
        listOne.add(100500);

        listTwo.add(3);
        listTwo.add(1);

        Assert.assertFalse("List two is  Not subSequence of list one. " , sub.isSubSequence(listOne, listTwo));
    }
}
