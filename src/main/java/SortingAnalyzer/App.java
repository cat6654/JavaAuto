package SortingAnalyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 14.12.2014.
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> unsortedList = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("\\d+");

        Scanner scanner = new Scanner(new FileInputStream(("src/main/java/SortingAnalyzer/data.txt")));
        try {
            while (scanner.hasNext()) {
                Matcher matcher = pattern.matcher(scanner.next());
                while (matcher.find()) {
                    unsortedList.add(Integer.parseInt(matcher.group()));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            scanner.close();
        }
        for (Integer element : unsortedList){
            System.out.println(element);
        }
    }
}
