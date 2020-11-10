package IE3_ADL_LAB2.com.mhelghamrawy;

import java.util.Stack;

public class Tree {

    private final BiNode rootNode;

    public class BiNode {
        public String element;

        public BiNode leftChildNode;
        public BiNode rightChildNode;

        public BiNode(String element) {
            this.element = element;
        }
    }

    public Tree(String postfix) {
        rootNode = construct(postfix);
    }

    public BiNode construct(String postfix) {
        // tokenize the input postfix expression
        String[] tokenizer;
        tokenizer = postfix.split(" ");

        // stack to temporarily hold nodes
        Stack<BiNode> stack;
        stack = new Stack<>();

        // Traverse through every element of the input postfix expression
        for (int i = 0; i < tokenizer.length; i++) {
            BiNode tree;
            // If binary operator, construct new parent node and add children from stack
            if(MathSupport.isBinaryOperator((tokenizer[i]))) {
                tree = new BiNode(tokenizer[i]);

                // Pop two top nodes
                tree.rightChildNode = stack.pop();
                tree.leftChildNode = stack.pop();

                // Add this element to stack
                stack.push(tree);
            }
            // If unary operator, construct new parent node and add child from stack
            else if(MathSupport.isUnaryOperator(tokenizer[i])) {
                tree = new BiNode(tokenizer[i]);

                tree.leftChildNode = stack.pop();

                // Add this element to stack
                stack.push(tree);
            }
            else { // If operand, simply push into stack
                stack.push(new BiNode(tokenizer[i]));
            }
        }
        return stack.pop();
    }

    /**
     * A method which tokenizes the String with the postfix arithmetic term,
     * and uses a stack of Strings (java.util.Stack<String>) to store the tokens of the arithmetic expression.
     *
     * @author Mohamed ElGhamrawy
     * */
    public Stack<String> tokenize(String postfix) {
        // initialize return variable
        Stack<String> tokenizedExpression;
        tokenizedExpression = new Stack<>();

        // step 1: tokenize postfix expression
        String[] tokenizer;
        tokenizer = postfix.split(" ");

        // step 2: form stack
        for (int i = 0; i <= tokenizer.length - 1; i++) {
            tokenizedExpression.push(tokenizer[i]);
        }
        return tokenizedExpression;
    }

    public void postorderTraversal() {

    }

    private void postorderTraversal(BiNode rootNode) {

    }

}
