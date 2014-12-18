package HomeWork2;

import tasks.SubSequenceAlgorithm;

import java.util.List;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class SubSequence<E> implements SubSequenceAlgorithm<E> {
    public boolean isSubSequence(List<E> list1, List<E> list2) {
        int occurrences = 0;
        E nextStartingElement = list1.get(0);
        if(nextStartingElement != null){
            //occurrences = 0;
            for (E list2Element : list2) {
                for (E list1Element : list1.subList(list1.indexOf(nextStartingElement),list1.size())) {
                    if (list2Element.equals(list1Element)){
                        occurrences++;
                        nextStartingElement = list1Element;
                        break;
                    }
                }
                if (occurrences < 1) return false;
                occurrences = 0;
            }
        } else {
            throw new RuntimeException("List one is empty, bro");
        }
        return true;
    }

}
