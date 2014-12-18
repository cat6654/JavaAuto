package HomeWork2;

import com.sun.javafx.scene.layout.region.Margins;
import sun.misc.Regexp;
import tasks.StringSumAlgorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 09.12.2014.
 */
public class JavaRegex implements StringSumAlgorithm {
    public double getSumFromString(String inputString){
        double sum = 0;
        Pattern patternDouble = Pattern.compile("\\d+[.]\\d+");
        Pattern patternInt = Pattern.compile("\\d+");
        Matcher matcherDouble  = patternDouble.matcher(inputString);
        while (matcherDouble.find())
        {
            sum+= Double.parseDouble(matcherDouble.group());
            inputString = inputString.replace(matcherDouble.group(),"");
        }
        Matcher matcherInt = patternInt.matcher(inputString);
        while (matcherInt.find())
        {
            sum+= Double.parseDouble(matcherInt.group());
        }
        return sum;
    }

}
