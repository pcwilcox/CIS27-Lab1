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
    }
}
