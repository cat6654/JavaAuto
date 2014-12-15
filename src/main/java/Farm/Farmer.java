package Farm;

import java.util.*;

/**
 * Created by Alexander on 14.12.2014.
 */
public class Farmer {
    public List<Plant> buyPlants(int numberOfPlants){
        List<Plant> listOfPlants = new ArrayList<Plant>();
        for(int i =0; i< numberOfPlants; i++){
            listOfPlants.add(Market.getPlant());
        }
        return listOfPlants;
    }

    public void setPlantsIntoFarm(List<Plant> plants){
        for(int i =0; i < plants.size(); i++){
            if(i>= Farm.capacity) break;
            Farm.plantPlaces.put(plants.get(i), 0);
        }
    }

    public void waterPlants(int w){
        if(Farm.plantPlaces != null) {
            for (Map.Entry<Plant, Integer> plant : Farm.plantPlaces.entrySet()) {
                plant.getKey().water(w);
            }
        }else{
            System.out.println("There are no plants on a Farm, man.");
        }
    }

    public Map<String, Integer> gatherPlants(){
        Map<String, Integer> gatheredPlants = new HashMap<String, Integer>();
        for (Map.Entry<Plant, Integer> plant : Farm.plantPlaces.entrySet()) {
            if(plant.getKey().canBeHarvested() == true) gatheredPlants.put(plant.getKey().getClass().getName(), plant.getValue());
        }
        return gatheredPlants;
    }

    public Farmer(){
        Random rand = new Random();
        setPlantsIntoFarm(buyPlants(rand.nextInt(9) + 1));
        waterPlants(rand.nextInt(10));
    }

}
