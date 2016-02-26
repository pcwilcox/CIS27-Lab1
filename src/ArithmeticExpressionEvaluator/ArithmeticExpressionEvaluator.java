package ArithmeticExpressionEvaluator;

/**
 * Created by Pete on 2/23/2016.
 */
public class ArithmeticExpressionEvaluator
{
    public static void main(String[] args)
    {
        System.out.println("First test: ( 1 + 2 + 3 + 4 )");

        InfixToPostfix infix = new InfixToPostfix("( 1 + 2 + 3 + 4 )");

        System.out.println(infix.toString());

        System.out.println("Ok that seems to have worked, let's try a more complicated one: " +
                           "( 1 + ( 3 * ( 4 / ( 8 - ( 12 + 5 ) * 18 ) ) / 4 ) - 6 )");

        InfixToPostfix infix2 = new InfixToPostfix("( 1 + ( 3 * ( 4 / ( 8 - ( 12 + 5 ) * 18 ) ) / 4 ) - 6 )");
        System.out.println(infix2.toString());

        Postfix postfix = new Postfix(infix2.toString());

        double value = postfix.getOutput();

        System.out.println("The postfix output is: " + value);

        System.out.println("Ok that worked, let's try another: ( 19 - 47 + ( 83 / ( 4 * 23 - 8 ) + 53 / 8 + 19 ) * 3 + 43 )");
        InfixToPostfix infix3 = new InfixToPostfix("( 19 - 47 + ( 83 / ( 4 * 23 - 8 ) + 53 / 8 + 19 ) * 3 + 43 )");
        System.out.println(infix3.toString());
        Postfix postfix2 = new Postfix(infix3.toString());
        value = postfix2.getOutput();
        System.out.println("The postfix output is: " + value);
    }
}
