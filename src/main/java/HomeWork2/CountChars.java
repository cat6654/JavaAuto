package HomeWork2;

import com.sun.xml.internal.ws.util.StringUtils;
import tasks.CharacterDistributionAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class CountChars implements CharacterDistributionAlgorithm {
    public Map<Character,Integer> getDistribution(String s)
    {
        Map<Character,Integer> mapOfChars = new HashMap<Character, Integer>();
        if (s != null) {
            s = s.replaceAll("[^\\p{L}\\p{Nd}]+", ""); //remove all non chars that might be in input string
            s = s.replaceAll("[^a-zA-Z]+", "");
            for (Character c : s.toCharArray()) {
                Integer count = mapOfChars.get(c);
                if(count==null ){
                    count = 1;
                } else {
                    count++;
                }
                mapOfChars.put(c, count);
            }
        }
        return mapOfChars;

    }

}
