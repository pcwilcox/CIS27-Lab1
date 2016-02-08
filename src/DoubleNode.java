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

    // Add a node to the front of the list
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

    // Add a node to the back of the list
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

    // Return the first node
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

    // Return the last node
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

    // Return true if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of nodes
    public int getSize() {
        return size;
    }

    // Add a node before the nth node
    public void addBefore(Item item, int n) {
        if (n < 2) {
            addToFront(item);
        } else if (n > size) {
            addToBack(item);
        } else {
            Node temp = new Node();
            temp.item = item;
            Node current = first;
            for (int i = 1; i < n; i++) {
                current = current.previous;
            }

            System.out.println("Adding " + temp.item.toString() + " before " + current.item.toString() + " and after " + current.next.item.toString() + ".");
            temp.next = current.next;
            temp.previous = current;
            current.next.previous = temp;
            current.next = temp;

            size++;
        }

    }

    // Add a node after the nth node
    public void addAfter(Item item, int n) {
        if (n < 1) {
            addToFront(item);
        } else if (n >= size) {
            addToBack(item);
        } else {
            Node temp = new Node();
            temp.item = item;
            Node current = first;
            for (int i = 1; i < n; i++) {
                current = current.previous;
            }

            System.out.println("Adding " + temp.item.toString() + " after " + current.item.toString() + " and before " + current.previous.item.toString() + ".");
            temp.next = current;
            current.previous.next = temp;

            temp.previous = current.previous;
            current.previous = temp;

            size++;
        }
    }

    // Removes the nth element
    public void remove(int n) {
        if (n > 0 && n <= size) {
            Node current = first;
            for (int i = 1; i < n; i++) {
                current = current.previous;
            }

            System.out.println("Removing " + current.item.toString() + ".");

            if (first == current) {
                if (current.previous != null) {
                    first = current.previous;
                } else {
                    first = null;
                }
            } else if (last == current) {
                current.next.previous = null;
                last = current.next;
            } else {
                current.next.previous = current.previous;
                current.previous.next = current.next;
            }
            current = null;
            size--;


        }
    }

    // Move the nth node to the front
    public void moveToFront(int n) {
        if (n > 1 && n <= size) {
            Node current = first;
            for (int i = 1; i <= n; i++) {
                current = current.previous;
            }

            System.out.println("Moving " + current.item.toString() + " to the front of the list.");

            if (current.previous != null) {
                current.next.previous = current.previous;
                current.previous.next = current.next;
            } else {
                current.next.previous = null;
            }

            current.previous = first;
            current.next = null;
            first.next = current;
            first = current;
        }
    }

    // Move the nth node to the back
    public void moveToBack(int n) {
        if (n > 0 && n < size) {
            Node current = first;
            for (int i = 1; i <= n; i++) {
                current = current.previous;
            }

            System.out.println("Moving " + current.item.toString() + " to the back of the list.");

            current.next.previous = current.previous;
            current.previous.next = current.next;
            current.previous = null;
            current.next = last;
            last.previous = current;
            last = current;
        }
    }
}