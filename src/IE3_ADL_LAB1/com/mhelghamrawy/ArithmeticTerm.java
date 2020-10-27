package IE3_ADL_LAB1.com.mhelghamrawy;

import java.util.Stack;

public class ArithmeticTerm {

    private final String expression;
    private final Stack<String> reversedExpression;

    {
        reversedExpression = new Stack<>();
    }

    public ArithmeticTerm(String expression) {
        this.expression = expression;
        reverse();
    }

    public String toString() {
        return expression;
    }

    public void reverse() {
        String[] tokenizer;
        tokenizer = expression.split(" ");

        for (int i = tokenizer.length - 1; i >= 0; i--) {
            reversedExpression.push(tokenizer[i]);
        }
    }

    public double evaluate() {
        StackOfDoubles operandStack;
        operandStack = new StackOfDoubles();

        while (!reversedExpression.isEmpty()) {
            String element;
            element = reversedExpression.pop();

            // Addition
            if (element.equals("+"))
                operandStack.push(operandStack.pop() + operandStack.pop());
            // Subtraction
            else if (element.equals("-"))
                operandStack.push(-operandStack.pop() + operandStack.pop());
            // Multiplication
            else if (element.equals("*"))
                operandStack.push(operandStack.pop() * operandStack.pop());
            // Division
            else if (element.equals("/"))
                operandStack.push((1/operandStack.pop()) * operandStack.pop());
            // Square root
            else if (element.equals("sqrt"))
                operandStack.push(Math.sqrt(operandStack.pop()));
            // Exponentiation
            else if (element.equals("^")) {
                double base;
                base = operandStack.pop();

                operandStack.push(Math.pow(base, operandStack.pop()));
            }
            // Factorials
            else if (element.endsWith("!")) {
                element = element.substring(0, element.length() - 1);
                try {
                    operandStack.push(factorial(Integer.parseInt(element)));
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected value: " + element);
                }
            }
            else {
                try {
                    operandStack.push(Double.parseDouble(element));
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected value: " + element);
                }

            }
        }
        double bottom = operandStack.pop();

        if (operandStack.isEmpty())
            return bottom;
        else
            throw new IllegalStateException("Incorrect number of arguments given.");
    }

    private int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n*factorial(n-1);

    }

    public Stack<String> getReversedExpression() {
        return reversedExpression;
    }
}
