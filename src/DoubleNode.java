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
        first.next = temp;
        first = temp;
        size++;
    }

    public void addToBack(Item i) {
        Node temp = new Node();
        temp.item = i;
        temp.next = last;
        last.previous = temp;
        last = temp;
        size++;
    }

    public Item popFromFront() {
        if (size > 0) {
            Node temp = new Node();
            temp = first;
            first.previous.next = null;
            first = first.previous;
            return temp.item;
        } else {
            return null;
        }
    }

    public Item popFromBack() {
        if (size > 0) {
            Node temp = new Node();
            temp = last;
            last.next.previous = null;
            last = last.next;
            return temp.item;
        } else {
            return null;
        }
    }

}