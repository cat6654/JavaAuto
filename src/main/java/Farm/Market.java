package Farm;

import java.util.Random;

/**
 * Created by Alexander on 14.12.2014.
 */
public class Market {
    public static Plant getPlant() {
        Random rand = new Random();
        int randomPlantNumber = rand.nextInt(10);
        if(randomPlantNumber < 3) return new Onion();
        if(randomPlantNumber < 7) return new Apple();
        if(randomPlantNumber <= 10) return new Cherry();

        return null;
    }
}
