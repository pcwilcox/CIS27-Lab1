package ArithmeticExpressionEvaluator;

/**
 * Created by Pete Wilcox on 2/11/2016.
 */
public class Stack<Item> {
    // Very simple pushdown stack class
    private Node first;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    public Stack(Item i) {
        first = new Node();
        first.item = i;
        size++;
    }

    public Stack() {
    }

    public void push(Item i) {
        Node temp = new Node();
        temp.item = i;
        temp.next = first;
        first = temp;
        size++;
    }

    public Item pop() {
        if (size > 0) {
            Node temp = first;
            first = first.next;
            size--;
            return temp.item;
        }
        return null;
    }

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
