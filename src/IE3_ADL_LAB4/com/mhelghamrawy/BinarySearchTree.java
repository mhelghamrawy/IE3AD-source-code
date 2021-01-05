package IE3_ADL_LAB4.com.mhelghamrawy;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    /**
     * An inner class of BinarySearchTree to handle its iteration.
    */
    public class BinarySearchTreeIterator implements Iterator<Key>{
        private Stack<Node> stack = new Stack<Node>();
        BinarySearchTreeIterator() {
            pushLeft(root);
            System.out.println(getMeanDepth());
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            //System.out.println(nodeDepth(x));
            return x.key;
        }

        private int getMeanDepth() {
            int totalDepth = 0;
            while (hasNext()) {
                Node x = stack.pop();
                pushLeft(x.right);
                totalDepth =+ nodeDepth(x);
            }
            return totalDepth;
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;

            }
        }
    }
    /**
     * An inner class of BinarySearchTree to represent the nodes of the Binary Search Tree.
     */
    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;

        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    private Node root; /** Reference to the root node of the tree*/
    private int nodeCount;

    @Override
    public Iterator<Key> iterator() {
        return new BinarySearchTreeIterator();
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            x.val = val;
        }
        else if (cmp < 0) {
            x.left = put(x.left, key, val);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        nodeCount++;
        return x;
    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.val;
            }
            else if (cmp < 0) {
                x = x.left;
            }
            else if(cmp > 0) {
                x = x.right;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    public int maxTreeDepth() {
        return maxTreeDepth(root);
    }

    private int maxTreeDepth(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftSubtreeDepth = maxTreeDepth(root.left);
            int rightSubtreeDepth = maxTreeDepth(root.right);

            if(leftSubtreeDepth > rightSubtreeDepth) {
                return leftSubtreeDepth + 1;
            }
            else {
                return rightSubtreeDepth + 1;
            }
        }
    }

    public double meanTreeDepth() {
        return meanTreeDepth(root);
    }

    private double meanTreeDepth(Node root) {
        return maxTreeDepth(root) / (double) nodeCount;
    }

    private int nodeDepth(Node node) {
        return maxTreeDepth(root)-maxTreeDepth(node);
    }
}