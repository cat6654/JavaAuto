package Farm;

import HomeWork2.CountChars;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Alexander on 14.12.2014.
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Farm farm = new Farm(scanner.nextInt());
        Farmer farmer = new Farmer();
        farm.growPlants();
        farmer.gatherPlants();

        for(Map.Entry<String, Integer> element :farmer.gatherPlants().entrySet())
        {
            System.out.println(element.getKey() + ":" + element.getValue());
        }




    }
}
