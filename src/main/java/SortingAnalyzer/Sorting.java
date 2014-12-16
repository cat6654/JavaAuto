package SortingAnalyzer;

import LinkedCollection.LinkedList;

/**
 * Created by akosatuchenko on 12/15/2014.
 */
public class Sorting {
    public static void bubbleSort( LinkedList num )
    {
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        int temp;   //holding variable

        while ( flag )
        {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < num.size() -1;  j++ )
            {
                if ( Integer.parseInt(num.get(j).toString())  > Integer.parseInt(num.get(j + 1).toString()))   // change to > for ascending sort
                {
                    temp = Integer.parseInt(num.get(j).toString());
                    num.set(num.get(j + 1), j);
                    num.set(temp, j + 1);
                    flag = true;              //shows a swap occurred
                }
            }
        }
    }

    public static void selectionSort(LinkedList data){
        int lenD = data.size();
        int j = 0;
        int tmp = 0;
        for(int i=0;i<lenD;i++){
            j = i;
            for(int k = i;k<lenD;k++){
                if( Integer.parseInt(data.get(j).toString())  > Integer.parseInt(data.get(k).toString())){
                    j = k;
                }
            }
            tmp = Integer.parseInt(data.get(i).toString());
            data.set(data.get(j), i);
            data.set(tmp, j);
        }
    }
}
