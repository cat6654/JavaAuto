package Farm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 14.12.2014.
 */
public class Farm {
    public static int capacity = 0;
    public static Map<Plant,Integer> plantPlaces = new HashMap<Plant, Integer>();

    public Farm(int c){
        capacity = c;
    }

    public void growPlants(){
        if (plantPlaces != null){
            for (Map.Entry<Plant, Integer> plant : Farm.plantPlaces.entrySet()) {
                plant.setValue(plant.getKey().getGrowth());
                }
            }
    }

}
