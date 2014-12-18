package LinkedCollection;

/**
 * Created by Alexander on 14.12.2014.
 */
public class App {
    public static void main( String[] args ) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("first something");
        linkedList.add("second something");
        linkedList.add("i don't know something");
        linkedList.add("whatever something");
        linkedList.add("maybe last something");

        linkedList.remove("first something");
        System.out.println("linked list size is : " + linkedList.size());
        //System.out.println("linked list contains 'whatever': " + linkedList.contains("whatever"));

        for(int i =0; i < linkedList.size(); i++ ){
            System.out.println(linkedList.get(i));
        }

        //for(Object element : linkedList.toArray()) {
          //  System.out.println("to array : " + element);
        //}

    }
}
