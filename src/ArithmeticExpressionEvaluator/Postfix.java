package ArithmeticExpressionEvaluator;

import java.util.Scanner;

/**
 * Created by Lord Yod on 2/24/2016.
 */
public class Postfix {
    // This class takes a postfix expression, formatted as a whitespace-delimited string, and evaluates it to a double
    private Scanner input;
    private String token;
    private Stack<Double> operands;
    private double output;
    private double val;

    public Postfix(String exp) {
        input = new Scanner(exp);

        operands = new Stack();

        while (input.hasNext()) {
            token = input.next();

            if (token.equals("(")) {

            } else if (token.equals("+")) {
                val = operands.pop();
                val = operands.pop() + val;
                operands.push(val);
            } else if (token.equals("-")) {
                val = operands.pop();
                val = operands.pop() - val;
                operands.push(val);
            } else if (token.equals("*")) {
                val = operands.pop();
                val = operands.pop() * val;
                operands.push(val);
            } else if (token.equals("/")) {
                val = operands.pop();
                val = operands.pop() / val;
                operands.push(val);
            } else {
                operands.push(new Double(token));
            }
        }


        output = operands.pop();
    }

    public double getOutput() {
        return output;
    }
}
