package SortingAnalyzer;

import java.util.ArrayList;

/**
 * Created by Alexander on 15.12.2014.
 */
public class MyArrayList<E> extends ArrayList<E> {
    public int writes = 0;
    public int reads = 0;
    @Override
    public boolean add(E var1){
        writes++;
        return true;
    }

}
