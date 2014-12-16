package SortingAnalyzer;

import LinkedCollection.LinkedList;

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
        LinkedList unsortedLinkedListOne = new LinkedList();
        LinkedList unsortedLinkedListTwo = new LinkedList();
        Pattern pattern = Pattern.compile("\\d+");

        Scanner scanner = new Scanner(new FileInputStream(("src/main/java/SortingAnalyzer/data.txt")));
        try {
            while (scanner.hasNext()) {
                Matcher matcher = pattern.matcher(scanner.next());
                while (matcher.find()) {
                    unsortedLinkedListOne.add(Integer.parseInt(matcher.group()));
                    unsortedLinkedListTwo.add(Integer.parseInt(matcher.group()));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            scanner.close();
        }
        //for(int i =0; i < unsortedLinkedList.size(); i++ ){
        //    System.out.println(unsortedLinkedList.get(i));
        //}
        Sorting.bubbleSort(unsortedLinkedListOne);
        System.out.println("Sorted with Bubble Sort");
        //for(int i =0; i < unsortedLinkedList.size(); i++ ){
        //    System.out.println(unsortedLinkedList.get(i));
        //}
        System.out.println("Bubble sorting results. Writes: " + unsortedLinkedListOne.writes + " " + "Reads: " + unsortedLinkedListOne.reads);
        Sorting.selectionSort(unsortedLinkedListTwo);
        System.out.println("Sorted with Selection Sort");
        System.out.println("Selection sorting results. Writes: " + unsortedLinkedListTwo.writes + " " + "Reads: " + unsortedLinkedListTwo.reads);


    }
}
