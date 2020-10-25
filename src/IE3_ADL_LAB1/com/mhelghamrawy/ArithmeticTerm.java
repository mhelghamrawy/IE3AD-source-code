package IE3_ADL_LAB1.com.mhelghamrawy;

import java.util.Stack;

public class ArithmeticTerm {

    private String expression;
    private Stack<String> reversedExpression;

    {
        reversedExpression = new Stack<String>();
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

    public String getExpression() {
        return expression;
    }

    public Stack<String> getReversedExpression() {
        return reversedExpression;
    }
}
