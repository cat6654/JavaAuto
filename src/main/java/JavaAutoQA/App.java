package JavaAutoQA;

import HomeWork2.HorizontalPyramid;
import HomeWork2.LeapYear;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        //LeapYear
        //System.out.println((LeapYear.isLeapYear(scanner.nextInt())));

        //Horizontal Pyramid
        for(String element : HorizontalPyramid.buildPyramid(scanner.nextInt()))
        {
            System.out.println(element);
        }
        //System.out.println((HorizontalPyramid.buildPyramid(scanner.nextInt())));
    }
}
