package HomeWork2;

import java.util.List;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class SubSequence {
    public static boolean checkSubSequence(List<Integer> list1, List<Integer> list2)
    {
        int occurrences = 0;
       for(Integer list2Element : list2)
       {
           for(Integer list1Element : list1)
           {
               if(list2Element == list1Element) occurrences++;
           }
           if(occurrences < 1) return false;
           occurrences =0;
       }

        return true;
    }

}
