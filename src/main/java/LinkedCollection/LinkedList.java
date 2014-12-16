package LinkedCollection;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by Alexander on 14.12.2014.
 */
public class LinkedList
{
    private Node head;
    private int listCount;
    public int writes = 0;
    public int reads = 0;

    public LinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 1; i < index && current.getNext() != null; i++)
        {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }

    public void set(Object data, int index) {
        Node current = head.getNext();
        for(int i = 0; i < index; i++)
        {
            if(current.getNext() == null) break;
            current = current.getNext();
        }
        current.setData(data);
        writes++;
    }

    public Object get(int index) {
        if(index < 0)
            return null;

        Node current = head.getNext();
        for(int i = 0; i < index; i++)
        {
            if(current.getNext() == null) return null;
            current = current.getNext();
        }
        reads++;
        return current.getData();
    }

    public boolean remove(int index) {
        if(index < 1 || index > size())
            return false;

        Node current = head;
        for(int i = 1; i < index; i++)
        {
            if(current.getNext() == null)
                return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }

    public int size() {
        return listCount;
    }

    public Object[] toArray() {
        Node current = head.getNext();
        Object[] output = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            if(current != null) {
                output[i] = current.getData().toString();
                current = current.getNext();
            }
        }
        return output;
    }

    public Boolean contains(Object data) {
        Node current = head.getNext();
        while(current != null) {
            if(current.data.toString().contains(data.toString())) return true;
            current = current.getNext();
        }
        return false;
    }

        private class Node {
        Node next;
        Object data;

        public Node(Object d) {
            next = null;
            data = d;
        }

        public Node(Object d, Node n) {
            next = n;
            data = d;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object d) {
            data = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }
}