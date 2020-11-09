package IE3_ADL_LAB2.com.mhelghamrawy;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class ArithmeticTerm {

    // a String to hold the value of the expression to be computed
    private String expression;
    // a Stack<String> to hold the reversed expression computed by reverse()
    public final Stack<String> reversedExpression;

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
     * and exponentiation (^);
     * and the following unary operators:
     * square-rooting (sqrt),
     * factorialization (!),
     * sine (sin),
     * cosine (cos),
     * tangent (tan),
     * natural exponentiation (exp),
     * and multiplication by pi (pi).
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
            // sine
            else if (element.equals("sin")) {
                operandStack.push(Math.sin(operandStack.pop()));
            }
            // cosine
            else if (element.equals("cos")) {
                operandStack.push(Math.cos(operandStack.pop()));
            }
            // tangent
            else if (element.equals("tan")) {
                operandStack.push(Math.tan(operandStack.pop()));
            }
            // natural exponentiation
            else if (element.equals("exp")) {
                operandStack.push(Math.exp(operandStack.pop()));
            }
            else if (element.equals("pi")) {
                operandStack.push(Math.PI*operandStack.pop());
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

    /**
     * Converts the FPAE (Fully Parenthesized Arithmetic Expression) from inFix form to postFix form
     * test cases are:
     * ( ( ( ( 6 + 4 ) ^ 2 ) - 5 ) / 2 )
     * ( ( 3 * 8 ) + ( ( sqrt 9 ) / 3 ) )
     * ( ( ( 4 * ( e 4 ) ) - 1 ) + ( sqrt 2 ) )
     * ( ( ( ( ( 3 - 2 ) * 4 ) / 2 ) * ( sqrt 4 ) ) ^ 2 )
     * ( ( ( ( ( ( 5 ^ 4 ) ^ 2 ) ^ 4 ) + 9 ) - 8 ) / 2 )
     * ( ( ( ( ( sqrt 4 ) * ( sqrt 9 ) ) - 6 ) * 6 ) + 4 )
     * @return postFixExpression A string that is converted from InFix form to postFix form
     * @author Hussam Kayed
     */
    public String convert() {
        StringTokenizer token = new StringTokenizer(this.expression);
        Stack<String> operatorStack = new Stack<String>();
        String postFixExpression = "";

        while (token.hasMoreTokens()) {
            String currentToken = token.nextToken();
            if (checkDouble(currentToken)) {
                postFixExpression += currentToken + " ";
            } else if (isBinaryOperator(currentToken) || isUnaryOperator(currentToken)) {
                operatorStack.push(currentToken);
            }
            else if(currentToken.equals("pi"))
            {
                postFixExpression += "pi" + " ";
            }
            else if (currentToken.equals(")")) {
                try {
                    postFixExpression += operatorStack.pop() + " ";
                } catch (EmptyStackException exception) {
                    System.out.println("Please check the syntax of the inserted arithmetic Expression");
                }
            }

        }
        this.expression = postFixExpression;

        return postFixExpression;
    }

    /*
     * A method which assists the convert() method by checking if a token is an operator.
     *
     * It supports the following binary operators:
     * addition (+),
     * subtraction (-),
     * multiplication (*),
     * division (/),
     * and exponentiation ("^");
     *
     * @parameters token a String holding the token to be checked
     * @return  a boolean, with true meaning that the token is an operator
     *
     * @author Mohamed ElGhamrawy
     * */
    public static boolean isBinaryOperator(String token)
    {
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                return true;
            default:
                return false;
        }
    }

    /*
     * A method which assists the convert() method by checking if a token is an operator.
     *
     * It supports the following unary operators:
     * square-rooting (sqrt),
     * factorialization (!),
     * sine (sin),
     * cosine (cos),
     * tangent (tan),
     * natural exponentiation (exp),
     * and multiplication by pi (pi).
     *
     * @parameters token a String holding the token to be checked
     * @return  a boolean, with true meaning that the token is an operator
     *
     * @author Mohamed ElGhamrawy
     * */
    public static boolean isUnaryOperator(String token)
    {
        switch (token) {
            case "sqrt":
            case "!":
            case "sin":
            case "cos":
            case "tan":
            case "exp":
            case "pi":
                return true;
            default:
                return false;
        }
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
