package Farm;

import HomeWork2.CountChars;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alexander on 14.12.2014.
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify Farm size.");
        Farm farm = new Farm(scanner.nextInt());
        Farmer farmer = new Farmer();
        farm.growPlants();
        //farmer.gatherPlants();
        Map<String, Integer> gatheredPlants = farmer.gatherPlants();
        Random rand = new Random();
        if(gatheredPlants.size() <1) {
            System.out.println("Water plants more, man");
            System.out.println("Farmer: watering...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            farmer.waterPlants(rand.nextInt(10));
        }
        for(Map.Entry<String, Integer> element :farmer.gatherPlants().entrySet())
        {
            System.out.println(element.getKey() + ":" + element.getValue());
        }




    }
}
