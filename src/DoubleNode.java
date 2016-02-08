/**
 * Created by Pete on 2/6/2016.
 */
public class DoubleNode<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;

    }

    public DoubleNode(Item i) {
        first = new Node();
        first.item = i;
        last = first;
        size++;
    }

    public DoubleNode() {
        size = 0;
    }

    public void addToFront(Item i) {
        Node temp = new Node();
        temp.item = i;
        temp.previous = first;
        if (size > 0) {
            first.next = temp;
        } else {
            last = temp;
        }
        first = temp;
        size++;

        System.out.println("Added " + temp.item + " to front, size is now " + size + ".");
    }

    public void addToBack(Item i) {
        Node temp = new Node();
        temp.item = i;

        if (size > 0) {
            temp.next = last;
            last.previous = temp;
        }
        last = temp;
        size++;
        System.out.println("Added " + temp.item + " to back, size is now " + size + ".");
    }

    public Item popFromFront() {
        if (size > 0) {
            Node temp = first;
            if (first.previous != null) {
                first.previous.next = null;
                first = first.previous;
            }
            size--;
            System.out.println("Popped " + temp.item + " from front, size is now " + size + ".");
            return temp.item;
        } else {
            return null;
        }
    }

    public Item popFromBack() {
        if (size > 0) {
            Node temp = last;
            last.next.previous = null;
            last = last.next;
            size--;
            System.out.println("Popped " + temp.item + " from back, size is now " + size + ".");
            return temp.item;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


}