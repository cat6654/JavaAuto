package HomeWork2;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class CountChars {
    public static Map<Character,Integer> countCharsInString(String s)
    {
        Map<Character,Integer> mapOfChars = new HashMap<Character, Integer>();

        if (s != null) {
            for (Character c : s.toCharArray()) {
                Integer count = mapOfChars.get(c);
                int newCount = (count==null ? 1 : count++);
                mapOfChars.put(c, newCount);
            }
        }
        return mapOfChars;

    }

}
