package Farm;

/**
 * Created by Alexander on 14.12.2014.
 */
public interface Plant {
    public void water(int w);
    public Boolean canBeHarvested();
    public int getGrowth();
}

 class Onion implements Plant {
    int growth = 0;
    int harvest = 2;
    int quantity = 2;
    @Override
    public void water(int w) {
        growth += w;
    }
     @Override
     public Boolean canBeHarvested() {
         if(growth > harvest) return true;
         return false;
     }
     @Override
     public int getGrowth() {
         return growth;
     }

 }

class Apple implements Plant {
    int growth = 0;
    int harvest = 5;
    String name = "Apple";
    @Override
    public void water(int w) {
        growth += w;
    }
    @Override
    public Boolean canBeHarvested() {
        if(growth > harvest) return true;
        return false;
    }
    @Override
    public int getGrowth() {
        return growth;
    }
}

class Cherry implements Plant {
    int growth = 0;
    int harvest = 6;
    String name = "Cherry";
    @Override
    public void water(int w) {
        growth += w;
    }
    @Override
    public Boolean canBeHarvested() {
        if(growth > harvest) return true;
        return false;
    }
    @Override
    public int getGrowth() {
        return growth;
    }
}