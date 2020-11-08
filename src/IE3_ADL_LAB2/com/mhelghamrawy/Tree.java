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
        // Reverse and tokenize the input postfix expression
        Stack<String> reversedExpression;
        reversedExpression = reverse(postfix);

        Stack<BiNode> stack;
        stack = new Stack<>();

        BiNode tree;
        BiNode child1;
        BiNode child2;

        // Traverse through every element of the input postfix expression
        while (!reversedExpression.isEmpty()) {
            String element;
            element = reversedExpression.pop();

            // If operand, simply push into stack
            if(!ArithmeticTerm.isOperator(element)) {
                tree = new BiNode(element);
            }
            else {
                tree = new BiNode(element);

                // Pop two top nodes
                // Store top
                try {
                    child1 = stack.pop();      // Remove top
                    child2 = stack.pop();

                    //  make them children
                    tree.rightChildNode = child1;
                    tree.leftChildNode = child2;
                } catch(Exception e) {}
            }
            // Add this element to stack
            stack.push(tree);
        }

        // last element will be root of expression tree
        try {
            tree = stack.pop();
        } catch (Exception e) {
            // throw exception when postfix expression doesn't contain enough elements
            throw new IllegalStateException("Incorrect number of arguments given.");
        }

        // throw exception when postfix expression doesn't contains extra elements
        if(!stack.isEmpty()) {
            throw new IllegalStateException("Incorrect number of arguments given.");
        }

        return tree;
    }

    /*
     * A method which tokenizes the String with the postfix arithmetic term,
     * and uses a stack of Strings (java.util.Stack<String>) to store the tokens of the arithmetic expression,
     * and writes it in the opposite order to the string instance variable.
     *
     * @author Mohamed ElGhamrawy
     * */
    public Stack<String> reverse(String postfix) {
        // initialize return variable
        Stack<String> reversedExpression;
        reversedExpression = new Stack<>();

        // step 1: tokenize postfix expression
        String[] tokenizer;
        tokenizer = postfix.split(" ");

        // step 2: reverse postfix expression
        for (int i = tokenizer.length - 1; i >= 0; i--) {
            reversedExpression.push(tokenizer[i]);
        }
        return reversedExpression;
    }
}
