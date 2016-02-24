package ArithmeticExpressionEvaluator;

/**
 * Created by Lord Yod on 2/24/2016.
 */
public class Postfix {
    // This class takes a postfix expression, formatted as a stack of strings, and evaluates it to a double
    private Stack<String> exp;
    private Stack<String> operators;
    private Stack<Double> operands;
    private double output;

    Postfix(Stack<String> input) {
        exp = input;
        operators = new Stack();
        operands = new Stack();

        // First we sort the input into operators and operands
        while (!exp.isEmpty()) {
            if (exp.getFirst().equals("+")
                    || exp.getFirst().equals("-")
                    || exp.getFirst().equals("*")
                    || exp.getFirst().equals("/")) {
                // If the element is an operator, it gets pushed to the operator stack
                System.out.println("Pushing " + exp.getFirst() + " to operator stack.");
                operators.push(exp.pop());

            } else {
                // Anything that isn't an operator is an operand, so we convert it to a double and push it there
                System.out.println("Pushing " + exp.getFirst() + " to operand stack.");
                operands.push(new Double(exp.pop()));
            }
        }

        // Then we iterate through the operators stack until it's empty
        while (!operators.isEmpty()) {
            String op = operators.pop();
            Double val = operands.pop();
            if (op.equals("+")) {
                val = operands.pop() + val;
            } else if (op.equals("-")) {
                val = operands.pop() - val;
            } else if (op.equals("*")) {
                val = operands.pop() * val;
            } else {
                val = operands.pop() / val;
            }
            operands.push(val);
        }

        output = operands.pop();
    }

    public double getOutput() {
        return output;
    }
}
