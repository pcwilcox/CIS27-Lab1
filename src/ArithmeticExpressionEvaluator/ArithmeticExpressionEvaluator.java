package ArithmeticExpressionEvaluator;

/**
 * Created by Pete Wilcox on 2/23/2016.
 */
public class ArithmeticExpressionEvaluator
{
    public static void main(String[] args)
    {
        System.out.println("First test: ( 1 + 2 + 3 + 4 )");

        InfixToPostfix infix1 = new InfixToPostfix("( 1 + 2 + 3 + 4 )");

        System.out.println("Postfix: " + infix1.toString());

        EvaluatePostfix evaluatePostfix1 = new EvaluatePostfix(infix1.toString());

        System.out.println("First output: " + evaluatePostfix1.getOutput());
        System.out.println("Ok that seems to have worked, let's try a more complicated one: " +
                           "( 1 + ( 3 * ( 4 / ( 8 - ( 12 + 5 ) * 18 ) ) / 4 ) - 6 )");

        InfixToPostfix infix2 = new InfixToPostfix("( 1 + ( 3 * ( 4 / ( 8 - ( 12 + 5 ) * 18 ) ) / 4 ) - 6 )");
        System.out.println("Postfix: " + infix2.toString());

        EvaluatePostfix evaluatePostfix2 = new EvaluatePostfix(infix2.toString());

        System.out.println("The evaluatePostfix output is: " + evaluatePostfix2.getOutput());

        System.out.println(
                "Ok that worked, let's try another: " +
                "( 19 - 47 + ( 83 / ( 4 * 23 - 8 ) + 53 / 8 + 19 ) * 3 + 43 )");
        InfixToPostfix infix3 = new InfixToPostfix("( 19 - 47 + ( 83 / ( 4 * 23 - 8 ) + 53 / 8 + 19 ) * 3 + 43 )");
        System.out.println("Postfix: " + infix3.toString());
        EvaluatePostfix evaluatePostfix3 = new EvaluatePostfix(infix3.toString());
        System.out.println("The evaluatePostfix output is: " + evaluatePostfix3.getOutput());

        System.out.println("Final test: " +
                           "( 81 / 19 * ( 3 * 47 - ( 53 + 17 ) / 18 ) + ( 62 - 7 * ( 15 / 4 ) + 5 ) - 6 )");

        InfixToPostfix infix4 =
                new InfixToPostfix("( 81 / 19 * ( 3 * 47 - ( 53 + 17 ) / 18 ) + ( 62 - 7 * ( 15 / 4 ) + 5 ) - 6 )");
        System.out.println("Postfix: " + infix4.toString());
        EvaluatePostfix evaluatePostfix4 = new EvaluatePostfix(infix4.toString());
        System.out.println("The final output is: " + evaluatePostfix4.getOutput());
    }
}
