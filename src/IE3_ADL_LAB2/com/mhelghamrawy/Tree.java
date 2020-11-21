package IE3_ADL_LAB2.com.mhelghamrawy;
/**
 * A class to a construct binary tree out of a postfix expression, enable post-order traversal of said binary tree,
 * and provide for support provisions thereof.
 *
 * @author Mohamed ElGhamrawy
 * */

import java.util.Stack;

public class Tree {
    // A field that holds the root node of the tree
    private final BiNode rootNode;

    // A field used to control indentation
    private StringBuffer indent= new StringBuffer();

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

    /**
     * A method which constructs a binary tree from a postfix expression.
     *
     * @parameters plus a boolean which increases and decreases the level of indentation
     * @author Mohamed ElGhamrawy
     * */
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

        // Validation check
        try {
            BiNode rootNode = stack.pop();

            if(stack.isEmpty()) {
                return rootNode;
            }
            else {
                MathSupport.throwIncompleteArgumentsException();
            }
        } catch (Exception e) {
            MathSupport.throwIncompleteArgumentsException();
        }
        return null;
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
    /**
     * A method which performs a post-order traversal of a binary tree by calling the recursive postorderTraversal()
     * method on the rootNode.
     *
     * @author Mohamed ElGhamrawy
     * */
    public void postorderTraversal() {
        postorderTraversal(rootNode);
    }

    /**
     * A method which assists postorderTraversal() by controlling indentation and hence the displaying the tree in a
     * visually comprehensible manner.
     *
     * @parameters plus a boolean which increases and decreases the level of indentation
     * @author Mohamed ElGhamrawy
     * */
    private void indentation(boolean plus) {
        if(plus) indent.append("    ");
        else indent.setLength(indent.length()-4);
    }

    /**
     * A method which assists postorderTraversal() by being recursively called to visit each node within the tree and
     * print the tree.
     *
     * @parameters node the current node to be traversed
     * @author Mohamed ElGhamrawy
     * */
    private void postorderTraversal(BiNode node) {
        indentation(true);

        //System.out.println(indent.toString() + "traverse(" + node.element + ")");

        if(node.leftChildNode!=null) postorderTraversal(node.leftChildNode);
        if(node.rightChildNode!=null) postorderTraversal(node.rightChildNode);

        System.out.println(indent.toString() + "visit(" + node.element + ")");
        //System.out.println(indent.toString() + "return");

        indentation(false);
    }

}
