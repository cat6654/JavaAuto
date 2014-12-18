package JavaAutoQA;

import HomeWork2.SubSequence;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 18.12.2014.
 */
public class SubSequenceJUnitTests {
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

        SubSequence sub = new SubSequence();
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

        SubSequence sub = new SubSequence();
        Assert.assertFalse("List two is  Not subSequence of list one. " , sub.isSubSequence(listOne, listTwo));
    }
}
