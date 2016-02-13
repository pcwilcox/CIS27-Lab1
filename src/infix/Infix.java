package infix;

/**
 * Created by Pete on 2/11/2016.
 */
public class Infix {
    private Stack<String> operators;
    private Stack<Integer> operands;

    Infix(String exp) {
        operators = new Stack<>();
        operands = new Stack<>();

        // Somehow split the string, not sure
        // String[] input = exp.split('\s');

        for (String i : input) {
            if (i.equals("+") ||
                    i.equals("-") ||
                    i.equals("/") ||
                    i.equals("*")) {
                // It's an operator, push it to the operator stack
                operators.push(i);
            } else if (i.equals(")")) {
                // Pop operators/operands, calculate, push it to operand
            } else {
                // It's a number, push it to the operand stack
                operands.push((int)i);
            }
        }


    }

}
