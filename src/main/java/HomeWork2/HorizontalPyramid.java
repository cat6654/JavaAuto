package HomeWork2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akosatuchenko on 12/9/2014.
 */
public class HorizontalPyramid {

    public static List<String> buildPyramid(int height)
    {
        List<String> listOfStrings = new ArrayList<String>();
        String result = "";
        int tempSize = 0;
        int previousSize = 0;

        for(int i = 1; i <= height; i++)
        {
            if(i == 1)
            {
                tempSize = i;
            }
            else
            {
                tempSize = previousSize + 2;
            }
            char[] firstPart = new char[height - i];
            char[] secondPart = new char[tempSize];
            previousSize = secondPart.length;
            Arrays.fill(firstPart, ' ');
            result += new String(firstPart);
            Arrays.fill(secondPart, '*');
            result +=new String(secondPart);
            result += new String(firstPart);
            listOfStrings.add(result);
            result = "";
        }

        return listOfStrings;
    }
}
