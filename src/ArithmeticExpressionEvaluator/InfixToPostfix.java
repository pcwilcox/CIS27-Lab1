package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Pete on 2/11/2016.
 */
public class InfixToPostfix {
    // This class converts an infex expression [i.e. 2 + (4 * 3)] to a postfix expression [2 4 3 * +]

    private Stack<String> operators;
    private Scanner input;
    private String output;
    private String token;

    InfixToPostfix(String exp) {
        operators = new Stack<>();
        input = new Scanner(exp);

        while(input.hasNext()) {
            // For every token in the expression
            token = input.next();

            // First sort out operators
            if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals("+") || token.equals("-")) {
                if (operators.getFirst() == "+" || operators.getFirst() == "-") {
                    buildOutput(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("*") || token.equals("/")) {
                if (operators.getFirst() == "*" || operators.getFirst() == "/") {
                    buildOutput(operators.pop());
                }
                operators.push(token);
            } else if (token.equals(")")) {
                while (operators.getFirst() != "(") {
                    buildOutput(operators.pop());
                }
                operators.pop();
            } else {
                // The token is an operand, so it goes straight to the output
                buildOutput(token);
            }
        }


    }

    private void buildOutput(String exp) {
        output = output.concat(exp);
    }

    public String toString() {
        return output;
    }
}
