package JavaAutoQA;

import HomeWork2.*;

import javax.swing.*;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world, fuckers ;)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Scanner scanner = new Scanner(System.in);
        //LeapYear
        System.out.println("LeapYear");
        System.out.println(LeapYear.isLeapYear(scanner.nextInt()));

        //Horizontal Pyramid
        System.out.println("Horizontal Pyramid");
        for(String element : HorizontalPyramid.buildPyramid(scanner.nextInt()))
        {
            //System.out.println(element);
        }

        //JavaRegex
        System.out.println("Sum from a string");
        System.out.println(JavaRegex.returnOnlyNumbers(scanner.nextLine()));

        //CountChars
        System.out.println("Character distribution");
        //System.out.println(CountChars.countCharsInString(scanner.nextLine())); //can print like that as well.
        for(Map.Entry<Character, Integer> element : CountChars.countCharsInString(scanner.nextLine()).entrySet())
        {
        System.out.println(element.getKey() + ":" + element.getValue());
        }*/

        //Simple game
        SimpleGame game = new SimpleGame("Guess a number");

        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(220, 150);
        game.setResizable(false);
        game.setLocationRelativeTo(null);

    }
}
