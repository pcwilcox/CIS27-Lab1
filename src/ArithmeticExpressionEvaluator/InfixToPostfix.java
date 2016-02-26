package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Pete Wilcox on 2/11/2016.
 */
public class InfixToPostfix
{
    // This class converts an infix expression [i.e. 2 + (4 * 3)] to a postfix expression [2 4 3 * +]

    private Stack<String> operators;
    private Scanner       input;
    private StringBuilder output;
    private String        token;
    private Stack<String> outputStack;

    InfixToPostfix(String exp)
    {
        /* This class is set up to run most everything when the constructor is called. Usage will be call the
            constructor with InfixToPostfix(expression), then use .toString() and .getOutput() to use the resulting
            converted expression.
         */
        output = new StringBuilder();
        operators = new Stack();
        input = new Scanner(exp);
        outputStack = new Stack();

        while (input.hasNext())
        {
            // For every token in the expression
            token = input.next();

            // We sort based on whether the token is an operator or an operand

            if (token.equals("("))
            {
                operators.push(token);
            }
            else if (token.equals("+") || token.equals("-"))
            {
                // If the operator on top of the stack has higher or equal presence, we push it to output
                if (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
                {
                    buildOutput(operators.pop());
                }
                else if (operators.getFirst().equals("+") || operators.getFirst().equals("-"))
                {
                    buildOutput(operators.pop());
                }

                // Then push the token operator
                operators.push(token);

            }
            else if (token.equals("*") || token.equals("/"))
            {
                // Same thing applies here except of course you only pop if it's equal precedence
                if (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
                {
                    buildOutput(operators.pop());
                }
                operators.push(token);
            }
            else if (token.equals(")"))
            {
                // When you get a ), pop all operators until you get the matching ( and push them to output
                while (!operators.getFirst().equals("("))
                {

                    buildOutput(operators.pop());
                }
                // Then get rid of the ()'s
                operators.pop();
            }
            else
            {
                // The token is an operand, so it goes straight to the output
                buildOutput(token);
            }
        }
    }

    private void buildOutput(String exp)
    {
        output.append(" " + exp);
        outputStack.push(exp);

    }

    public String toString()
    {
        output.trimToSize();
        return output.toString();
    }

    public Stack getOutput()
    {
        return outputStack;
    }
}
