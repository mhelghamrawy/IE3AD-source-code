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

    @Override
    public String toString() {
        return expression;
    }

    /**
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

    /**
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
                    operandStack.push(MathSupport.factorial(Integer.parseInt(element)));
                } catch (Exception e) {
                    MathSupport.throwUnexpectedValueException(element);
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
                    MathSupport.throwUnexpectedValueException(element);
                }
            }
        }
        double bottom = operandStack.pop();

        if (operandStack.isEmpty()) {
            return bottom;
        }
        else {
            MathSupport.throwIncompleteArgumentsException();
        }
        return bottom;
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
        Stack<String> operatorStack = new Stack<>();
        String postFixExpression = "";

        while (token.hasMoreTokens()) {
            String currentToken = token.nextToken();
            if (MathSupport.checkDouble(currentToken)) {
                postFixExpression += currentToken + " ";
            } else if (MathSupport.isBinaryOperator(currentToken) || MathSupport.isUnaryOperator(currentToken)) {
                operatorStack.push(currentToken);
            }
            else if(currentToken.equals("pi")) {
                postFixExpression += "pi" + " ";
            }
            else if (currentToken.equals(")")) {
                try {
                    postFixExpression += operatorStack.pop() + " ";
                } catch (EmptyStackException exception) {
                    MathSupport.throwIncompleteArgumentsException();
                }
            }

        }
        this.expression = postFixExpression;

        return postFixExpression;
    }

    public Stack<String> getReversedExpression() {
        return reversedExpression;
    }
}
