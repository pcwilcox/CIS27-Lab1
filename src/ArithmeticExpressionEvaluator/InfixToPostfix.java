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

    InfixToPostfix(String exp)
    {
        /* This class is set up to run most everything when the constructor is called. Usage will be call the
            constructor with InfixToPostfix(expression), then use .toString() and .getOutput() to use the resulting
            converted expression.
         */
        output      = new StringBuilder();
        operators   = new Stack();
        input       = new Scanner(exp);

        while (input.hasNext())
        {
            // For every token in the expression
            token = input.next();

            // We sort based on whether the token is an operator or an operand
            switch (token)
            {
                case ("("):
                    operators.push(token);
                    break;
                case ("+"):
                case ("-"):
                    // Pop operators off the stack as long as they have higher precedence
                    while (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
                    {
                        buildOutput(operators.pop());
                    }

                    // If the operator on top of the stack has equal precedence, push it to output
                    while (operators.getFirst().equals("+") || operators.getFirst().equals("-"))
                    {
                        buildOutput(operators.pop());
                    }

                    // Then push the token operator
                    operators.push(token);
                    break;
                case ("*"):
                case ("/"):
                    // Same thing applies here except of course you only pop if it's equal precedence
                    while (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
                    {
                        buildOutput(operators.pop());
                    }
                    operators.push(token);

                    break;
                case (")"):
                    // When you get a ), pop all operators until you get the matching ( and push them to output
                    while (!operators.getFirst().equals("("))
                    {

                        buildOutput(operators.pop());
                    }
                    // Then get rid of the ()'s
                    operators.pop();

                    break;
                default:
                    // The token is an operand, so it goes straight to the output
                    buildOutput(token);

            }
//            if (token.equals("("))
//            {
//                operators.push(token);
//            }
//            else if (token.equals("+") || token.equals("-"))
//            {
//                // If the operator on top of the stack has higher, push it to output
//                while (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
//                {
//                    buildOutput(operators.pop());
//                }
//
//                // If the operator on top of the stack has equal precedence, push it to output
//                if (operators.getFirst().equals("+") || operators.getFirst().equals("-"))
//                {
//                    buildOutput(operators.pop());
//                }
//
//                // Then push the token operator
//                operators.push(token);
//
//            }
//            else if (token.equals("*") || token.equals("/"))
//            {
//                // Same thing applies here except of course you only pop if it's equal precedence
//                while (operators.getFirst().equals("*") || operators.getFirst().equals("/"))
//                {
//                    buildOutput(operators.pop());
//                }
//                operators.push(token);
//            }
//            else if (token.equals(")"))
//            {
//                // When you get a ), pop all operators until you get the matching ( and push them to output
//                while (!operators.getFirst().equals("("))
//                {
//
//                    buildOutput(operators.pop());
//                }
//                // Then get rid of the ()'s
//                operators.pop();
//            }
//            else
//            {
//                // The token is an operand, so it goes straight to the output
//                buildOutput(token);
//            }
        }
    }

    private void buildOutput(String exp)
    {
        output.append(" " + exp);
    }

    public String toString()
    {
        output.trimToSize();
        return output.toString();
    }

}
