package arithmeticExpressionEvaluator;

/**
 * Created by Pete Wilcox on 2/11/2016.
 */
public class Stack<Item> {
    // Very simple LIFO stack class
    private Node first;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    // Constructor
    public Stack(Item i) {
        first = new Node();
        first.item = i;
        size++;
    }

    // Default constructor
    public Stack() {
    }

    // Push a new item to the stack
    public void push(Item i) {
        Node temp = new Node();
        temp.item = i;
        temp.next = first;
        first = temp;
        size++;
    }

    // Pop the first item from the stack
    public Item pop() {
        if (size > 0) {
            Node temp = first;
            first = first.next;
            size--;
            return temp.item;
        }
        return null;
    }

    // Returns the item held in the first node - used for checking equality
    public Item getFirst() {
        if (first != null) {
            return first.item;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
