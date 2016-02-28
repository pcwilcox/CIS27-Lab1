package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Pete Wilcox on 2/24/2016.
 */
public class EvaluatePostfix
{
    // This class takes a postfix expression, formatted as a whitespace-delimited string, and evaluates it to a double
    private Scanner       input;
    private String        token;
    private Stack<Double> operands;
    private double        output;
    private double        value;

    public EvaluatePostfix(String exp)
    {
        input = new Scanner(exp);
        operands = new Stack();

        // For every token in the expression
        while (input.hasNext())
        {
            token = input.next();
            // Use a switch to sort out correct operation
            switch (token) {
                case ("+"):
                    value = operands.pop(); // Pop the top operand to a temp value
                    value = operands.pop() + value; // Assign the correct value based on operator
                    operands.push(value); // Push that value back onto stack
                    break;
                case ("-"):
                    value = operands.pop();
                    value = operands.pop() - value;
                    operands.push(value);
                    break;
                case ("*"):
                    value = operands.pop();
                    value = operands.pop() * value;
                    operands.push(value);
                    break;
                case ("/"):
                    value = operands.pop();
                    value = operands.pop() / value;
                    operands.push(value);
                    break;
                default:
                    // The default case is that the token is an operand, so just push it to the stack
                    operands.push(new Double(token));
            }
        }

        // Anything remaining at this point is the final value of the expression
        output = operands.pop();
    }

    public double getOutput()
    {
        return output;
    }
}
