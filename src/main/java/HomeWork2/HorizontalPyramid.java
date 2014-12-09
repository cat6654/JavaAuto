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

        for(int i = 1; i < height; i++)
        {
            String[] firstPart = new String[height - i];
            String[] secondPart = new String[height - i];
            Arrays.fill(firstPart, " ");
            result += firstPart.toString();
            Arrays.fill(secondPart, "*");
            result+=secondPart.toString();
            result+=firstPart.toString();
            listOfStrings.add(result);
        }

        return listOfStrings;
    }

}
