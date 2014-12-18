package LinkedCollection;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Alexander on 14.12.2014.
 */
public class LinkedList<E> implements Collection<E> {
    private Node head;
    private int listCount;
    public int writes = 0;
    public int reads = 0;

    public LinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public boolean add(E data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
        return true;
    }

    public void add(E data, int index) {
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

    public void set(E data, int index) {
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
        for(int i = 1; i < index; i++) {
            if(current.getNext() == null)
                return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        while(!current.getNext().data.equals(o)) {
            if(current.getNext() == null){
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }

    public int size() {
        return listCount;
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) return true;
        return false;
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

    @Override
    public <T> T[] toArray(T[] a) {
        Node current = head.getNext();
        if (a.length < this.size())
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        System.arraycopy(this.toArray(), 0, a, 0, this.size());
        if (a.length > this.size())
            a[this.size()] = null;
        return a;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        writes++;
        // clear to let GC do its work
        for (int i = 0; i < this.size(); i++)
            this.toArray()[i] = null;

        listCount = 0;
    }

    public boolean contains(Object data) {
        Node current = head.getNext();
        while(current != null) {
            if(current.data.equals(data)) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = writes;

        public boolean hasNext() {
            return cursor != listCount;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= listCount)
                throw new NoSuchElementException();
            Object[] elementData = LinkedList.this.toArray();
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                LinkedList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = writes;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (writes != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class Node {
        Node next;
        E data;

        public Node(E d) {
            next = null;
            data = d;
        }

        public Node(E d, Node n) {
            next = n;
            data = d;
        }

        public E getData() {
            return data;
        }

        public void setData(E d) {
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