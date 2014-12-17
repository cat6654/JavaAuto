package HomeWork2;

import tasks.SubSequenceAlgorithm;

import java.util.List;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class SubSequence<E> implements SubSequenceAlgorithm<E> {
    public boolean isSubSequence(List<E> list1, List<E> list2)
    {
        int occurrences = 0;
       for(E list2Element : list2)
       {
           for(E list1Element : list1)
           {
               if(list2Element == list1Element) occurrences++;
           }
           if(occurrences < 1) return false;
           occurrences = 0;
       }
        return true;
    }

}
