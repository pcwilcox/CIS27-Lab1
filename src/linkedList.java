import java.util.Iterator;

/**
 * Created by Pete on 2/6/2016.
 */
public class DoubleNode<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public DoubleNode() {

    }

    public DoubleNode(Item i) {
        first = new Node();
        first.item = i;
        last = first;
        size = 1;
    }

    public void push(Item i) {
        // Add item to front of list
        Node oldFirst = first;
        first = new Node();
        first.item = i;
        first.next = oldFirst;
        first.next.previous = first;
    }

    public Item pop() {
        // Remove item from front of list
        Item i = first.item;
        first = first.next;
        size--;
        return i;
    }

    public void enq(Item i) {
        // Add item to end of list
        Node oldLast = last;
        last = new Node();
        last.item = i;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item deq() {
        // Remove item from end of list
        Item i = last.item;
        last = last.next;
        if (size > 0) {
            size--;
        }
        return i;
    }

    public void insertBefore(int n) {
        Node current = first;
        for (int i = 0; i < n; i++) {
            if(current.next != null) {
                current = current.next;
            }
        }


    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private Class ListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
        return current != null;
    }

    public void remove() {};

    public Item next() {
        Item i = current.item;
        current = current.next;
        return i;
    }
    }


}
