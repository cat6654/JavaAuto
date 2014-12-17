package JavaAutoQA;

import HomeWork2.*;

import javax.swing.*;
import java.io.Reader;
import java.util.*;

/**
 * Hello world, fuckers ;)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        //LeapYear
        System.out.println("LeapYear");
        LeapYear checkLeapYear= new LeapYear();
        System.out.println(checkLeapYear.isLeapYear(scanner.nextInt()));

        //Horizontal Pyramid
        System.out.println("Horizontal Pyramid");
        for(String element : HorizontalPyramid.buildPyramid(scanner.nextInt()))
        {
            //System.out.println(element);
        }

        //JavaRegex
        System.out.println("Sum from a string");
        JavaRegex javaRegex = new JavaRegex();
        System.out.println(javaRegex.getSumFromString(scanner.nextLine()));

        //CountChars
        System.out.println("Character distribution");
        CountChars countChars = new CountChars();
        for(Map.Entry<Character, Integer> element : countChars.getDistribution(scanner.nextLine()).entrySet())
        {
        System.out.println(element.getKey() + ":" + element.getValue());
        }

        //Simple game
        SimpleGame game = new SimpleGame("Guess a number");

        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(220, 150);
        game.setResizable(false);
        game.setLocationRelativeTo(null);

        //Subsequence
        System.out.println("Subsequence. give me two lists, Buddy");
        List<Integer> listOne = new ArrayList<Integer>();
        List<Integer> listTwo = new ArrayList<Integer>();
        Random rand = new Random();

        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));
        listOne.add(rand.nextInt(10));

        listTwo.add(rand.nextInt(10));
        listTwo.add(rand.nextInt(10));
        listTwo.add(rand.nextInt(10));

        System.out.print("ListOne: ");
        for(Integer list1Element : listOne)
        {
            System.out.print(list1Element + ",");
        }
        System.out.println("");
        System.out.print("ListTwo: ");
        for(Integer list1Element : listTwo)
        {
            System.out.print(list1Element + ",");
        }
        System.out.println("");
        SubSequence subS = new SubSequence();
        System.out.println(subS.isSubSequence(listOne, listTwo));
    }
}
