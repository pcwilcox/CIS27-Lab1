/**
 * Created by Pete on 2/7/2016.
 */
public class DoubleNodeTester {
    public static void main(String[] args) {
        DoubleNode list = new DoubleNode();
        System.out.println("Made a list.");

        System.out.println("Currently the list is empty: " + list.isEmpty());
        list.addToFront("Dick");
        list.addToBack("Harry");
        list.addToFront("Tom");

        System.out.println("Let's get the size, it's " + list.getSize() + ".");

        list.addBefore("Jane", 2);
        System.out.println("Size is now " + list.getSize() + ".");

        list.addAfter("Vivian", 3);
        System.out.println("Size is now " + list.getSize() + ".");

        list.remove(3);

        list.moveToBack(2);
        list.moveToFront(3);
        list.popFromFront();
        list.popFromBack();
        list.popFromFront();
    }
}
