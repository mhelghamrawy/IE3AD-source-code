package IE3_ADL_LAB5.com.mhelghamrawy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Huffman {
    private final String preorderSequence; // preorder sequence of huffman tree
    private Node root; // reference to root node of the Huffman tree
    private HashMap<Character, String> table = new HashMap<>();

    private Stack<Character> stack; // stack to temporarily hold characters during huffman tree construction
    private StringBuffer indent; // field used to control indentation during tree traversal display

    private class Node {
        char ch;
        Node left, right;
        Node(char ch) {
            this.ch = ch;
            if (ch == '*') {
                left = new Node(stack.pop());
                right = new Node(stack.pop());
            }
        }
        boolean isInternal() {
            return this.left != null || this.right != null;
        }
    }

    public Huffman(String preorderSequence) {
        this.preorderSequence = preorderSequence;
        initTree();
        initTable();
    }

    private void initTree() {
        // reverse string
        indent = new StringBuffer();
        stack = new Stack<Character>();
        StringBuffer reversedSequence = new StringBuffer(preorderSequence);
        reversedSequence.reverse();
        String s = reversedSequence.toString();
        // tokenize the input preorder expression
        char[] tokenizer;
        tokenizer = s.toCharArray();
        // fill stack to temporarily hold nodes
        for (int i = 0; i < tokenizer.length; i++) {
            stack.push(tokenizer[i]);
        }
        root = new Node(stack.pop());
    }

    private void initTable() {
        initTable(root, new StringBuffer());
        /*table.put('s', "0");
        table.put('e', "10");
        table.put('_', "110");
        table.put('l', "11101");
        table.put('h', "11100");
        table.put('a', "11110");
        table.put('b', "1111110");
        table.put('t', "11111000");
        table.put('o', "11111010");
        table.put('r', "11111000");
        table.put('y', "11111011");*/

    }

    public void initTable(Node tree, StringBuffer prefix) {
        assert tree != null;

        if(tree.isInternal()) {
            // traverse left
            //if(tree != this.root) {
                prefix.append('0');

            //}
            initTable(tree.left, prefix);
            //if(tree != this.root) {
                prefix.deleteCharAt(prefix.length()-1);

            //}

            // traverse right
            //if(tree != this.root) {
                prefix.append('1');
            //}
            initTable(tree.right, prefix);
            //if(tree != this.root) {
                prefix.deleteCharAt(prefix.length()-1);
            //}
        } else {
            // add character and code for this leaf (which is just the prefix) to hash map
            String temp = prefix.toString();
            table.put(tree.ch, temp);
        }

    }

    public String encode(String decodedSequence) {
        StringBuffer encodedSequence = new StringBuffer();
        char[] decodedSequenceArray = decodedSequence.toCharArray();

        for(char character : decodedSequenceArray) {
            encodedSequence.append(table.get(character));
        }

        return encodedSequence.toString();
    }

    public String decode(StringBuffer encodedSequence) {
        StringBuffer decodedSequence = new StringBuffer();

        for(int i = 0; i < encodedSequence.length(); i++) {
            Node x = root;
            while (x.isInternal()) {
                char bit = encodedSequence.charAt(i);
                //encodedSequence.deleteCharAt(i);
                if(bit == '0') {x = x.left;}
                else if(bit == '1') { x = x.right;}
            }
            decodedSequence.append(x.ch);
        }
        return decodedSequence.toString();
    }

    public void printCodes() {
        printCodes(root, new StringBuffer());
    }

    private void printCodes(Node tree, StringBuffer prefix) {
        assert tree != null;

        if (!tree.isInternal()) {
            // print out character and code for this leaf (which is just the prefix)
            System.out.println(tree.ch + "\t" + prefix);
        } else {
            // traverse left
            prefix.append('0');
            printCodes(tree.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(tree.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    /**
     * A method to display the tree.
     *
     * @author Mohamed ElGhamrawy
     */
    private void display() {
        preorderTraversal(root);
    }

    /**
     * A method which assists display() by controlling indentation and hence the displaying the tree in a
     * visually comprehensible manner.
     *
     * @parameters plus a boolean which increases and decreases the level of indentation
     * @author Mohamed ElGhamrawy
     */
    private void indentation(boolean plus) {
        if (plus) indent.append("    ");
        else indent.setLength(indent.length() - 4);
    }

    /**
     * A method which assists display() by being recursively called to visit each node within the tree and
     * print the tree.
     *
     * @parameters node the current node to be traversed
     * @author Mohamed ElGhamrawy
     */
    private void preorderTraversal(Node node) {
        indentation(true);
        //System.out.println(indent.toString() + "traverse(" + node.element + ")");
        System.out.println(indent.toString() + "visit(" + node.ch + ")");
        if (node.left != null) preorderTraversal(node.left);
        if (node.right != null) preorderTraversal(node.right);
        //System.out.println(indent.toString() + "return");
        indentation(false);
    }
}