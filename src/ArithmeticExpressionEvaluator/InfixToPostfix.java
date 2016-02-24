package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Pete on 2/11/2016.
 */
public class InfixToPostfix
{
    // This class converts an infix expression [i.e. 2 + (4 * 3)] to a postfix expression [2 4 3 * +]

    private Stack<String> operators;
    private Scanner input;
    private StringBuilder output;
    private String token;
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
            //System.out.println("Token: " + token);

            // First sort out operators
            if (token.equals("("))
            {
                System.out.println("Pushing " + token + " to stack.");
                operators.push(token);
            } else if (token.equals("+") || token.equals("-"))
            {
                if (operators.getFirst().equals("+") || operators.getFirst().equals("-"))
                {
                    System.out.println("Popping " + operators.getFirst());
                    buildOutput(operators.pop());
                }

                System.out.println("Pushing " + token + " to stack.");
                operators.push(token);

            } else if (token.equals("*") || token.equals("/"))
            {
                while (operators.getFirst().equals("+")
                       && !operators.getFirst().equals("-"))
                {
                    System.out.println("Popping " + operators.getFirst());
                    buildOutput(operators.pop());
                }
                System.out.println("Pushing " + token + " to stack.");
                operators.push(token);
            } else if (token.equals(")"))
            {
                while (!operators.getFirst().equals("("))
                {

                    System.out.println("Popping " + operators.getFirst());
                    buildOutput(operators.pop());
                }
                operators.pop();
            } else
            {
                // The token is an operand, so it goes straight to the output
                buildOutput(token);
            }
        }
    }

    private void buildOutput(String exp)
    {
        System.out.println("Pushing " + exp + " to output.");
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
