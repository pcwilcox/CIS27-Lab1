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

        String[] input = exp.split("\s");

        for (String i : input) {
            if (i.equals("+") ||
                    i.equals("-") ||
                    i.equals("/") ||
                    i.equals("*")) {
                operators.push(i);
            } else if (i.equals(")")) {
                // calculate value of expression
            } else {
                operands.push((int)i);
            }
        }


    }

}
