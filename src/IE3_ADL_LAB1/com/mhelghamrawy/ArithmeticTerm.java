package IE3_ADL_LAB1.com.mhelghamrawy;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class ArithmeticTerm {

    // a String to hold the value of the expression to be computed
    private final String expression;
    // a Stack<String> to hold the reversed expression computed by reverse()
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

    /*
     * A method which tokenizes the String with the arithmetic term,
     * and uses a stack of Strings (java.util.Stack<String>) to store the tokens of the arithmetic expression,
     * and writes it in the opposite order to the string instance variable.
     * Called during constructor call.
     *
     * @author Mohamed ElGhamrawy
     * */
    public void reverse() {
        String[] tokenizer;
        tokenizer = expression.split(" ");

        for (int i = tokenizer.length - 1; i >= 0; i--) {
            reversedExpression.push(tokenizer[i]);
        }
    }

    /*
     * A method which uses a stack of doubles to evaluate the postfix expression with
     * an extended version of the algorithm postfix2value that supports the following binary operators:
     * addition (+),
     * subtraction (-),
     * multiplication (*),
     * division (/),
     * and exponentiation ();
     * and the following unary operators:
     * square-rooting (sqrt), and factorialization (!).
     *
     * @return bottom a double which exists at the bottom of the stack at the end of execution, i.e. the answer
     *
     * @author Mohamed ElGhamrawy
     * */
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
                double power;
                power = operandStack.pop();

                operandStack.push(Math.pow(operandStack.pop(), power));
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

    /*
     * A method which assists the evaluate() method by calculating factorials recursively.
     *
     * @parameters n an integer to be factorialized
     * @return  an integer with the value of n!
     *
     * @author Mohamed ElGhamrawy
     * */
    private int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n*factorial(n-1);

    }

    /*
    * A method which uses a stack of strings to convert the FPAE into a postfix expression with
    * a modified version of the algorithm infix2postfix that supports unary operators as well
    *
    * @return postFixExpression a string containing the converted expression
    *
    * @author Hussam Kayed
    * */
    public String convert()
    {
        StringTokenizer token = new StringTokenizer(this.expression);
        Stack<String> operatorStack = new Stack<>();
        String postFixExpression = "";

        while(token.hasMoreTokens())
        {
            String currentToken = token.nextToken();
            if(checkDouble(currentToken))
            {
                postFixExpression += currentToken + " ";
            }
            else if(operators(currentToken))
            {
                operatorStack.push(currentToken);
            }
            else if(currentToken.equals(")"))
            {
                try
                {
                    postFixExpression += operatorStack.pop() + " ";
                } catch (EmptyStackException exception)
                {
                    System.out.println("Please check the syntax of the inserted arithmetic Expression");
                }
            }
            else
                continue;

        }
        return postFixExpression;
    }

    /*
     * A method which assists the convert() method by checking if a token is an operator.
     *
     * @parameters token a String holding the token to be checked
     * @return  a boolean, with true meaning that the token is an operator
     *
     * @author Hussam Kayed
     * */
    public boolean operators(String token)
    {
        if(token.equals("*"))
            return true;
        else if(token.equals("+"))
            return true;
        else if(token.equals("e"))
            return true;
        else if(token.equals("-"))
            return true;
        else if(token.equals("/"))
            return true;
        else if(token.equals("sqrt"))
            return true;
        else if(token.equals("^"))
            return true;
        else
            return false;
    }
    /*
     * A method which assists the convert() method by checking if a token is an operand of type double.
     *
     * @parameters token a String holding the token to be checked
     * @return  a boolean, with true meaning that the token is an operand of type double.
     *
     * @author Hussam Kayed
     * */
    public boolean checkDouble(String token)
    {
        try
        {
            Double.parseDouble(token);
        } catch(NumberFormatException exception)
        {
            return false;
        }
        return true;
    }

    public Stack<String> getReversedExpression() {
        return reversedExpression;
    }
}
