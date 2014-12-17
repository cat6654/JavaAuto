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
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find())
        {
            sum+= Integer.parseInt(matcher.group());
        }
        // casting back to string here.... because... I can )
        return sum;
    }

}
