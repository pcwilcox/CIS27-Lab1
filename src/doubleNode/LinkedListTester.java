
package doubleNode;

/**
 * Created by Pete Wilcox on 2/7/2016.
 */
public class LinkedListTester
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        System.out.println("Made a list.");

        System.out.println("Currently the list is empty: " + list.isEmpty());
        list.addToFront("Dick");
        list.addToBack("Harry");
        list.addToFront("Tom");
        System.out.println("The list is currently " + list.toString());

        System.out.println("Let's get the size, it's " + list.getSize() + ".");

        list.addBefore("Jane", 2);
        System.out.println("Size is now " + list.getSize() + ".");

        list.addAfter("Vivian", 3);
        System.out.println("Size is now " + list.getSize() + ".");

        System.out.println("The list is currently " + list.toString());
        list.remove(3);

        list.moveToBack(2);
        System.out.println("The list is currently " + list.toString());
        list.moveToFront(2);
        System.out.println("The list is currently " + list.toString());
        list.popFromFront();
        list.popFromBack();
        list.popFromFront();
        System.out.println("The list is currently " + list.toString());
    }
}
