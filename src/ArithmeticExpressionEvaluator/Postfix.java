package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Lord Yod on 2/24/2016.
 */
public class Postfix
{
    // This class takes a postfix expression, formatted as a whitespace-delimited string, and evaluates it to a double
    private Scanner       input;
    private String        token;
    private Stack<Double> operands;
    private double        output;
    private double        value;

    public Postfix(String exp)
    {
        input = new Scanner(exp);
        operands = new Stack();

        while (input.hasNext())
        {
            token = input.next();

            if (token.equals("+"))
            {
                value = operands.pop();
                value = operands.pop() + value;
                operands.push(value);
            }
            else if (token.equals("-"))
            {
                value = operands.pop();
                value = operands.pop() - value;
                operands.push(value);
            }
            else if (token.equals("*"))
            {
                value = operands.pop();
                value = operands.pop() * value;
                operands.push(value);
            }
            else if (token.equals("/"))
            {
                value = operands.pop();
                value = operands.pop() / value;
                operands.push(value);
            }
            else
            {
                operands.push(new Double(token));
            }
        }


        output = operands.pop();
    }

    public double getOutput()
    {
        return output;
    }
}
