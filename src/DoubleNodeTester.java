/**
 * Created by Pete on 2/7/2016.
 */
public class DoubleNodeTester {
    public static void main(String[] args) {
        DoubleNode list = new DoubleNode();
        System.out.println("Made a list, let's add some stuff.");

        list.addToFront("Dick");
        list.addToBack("Harry");
        list.addToFront("Tom");

        list.popFromFront();
        list.popFromBack();
        list.popFromFront();
    }
}
