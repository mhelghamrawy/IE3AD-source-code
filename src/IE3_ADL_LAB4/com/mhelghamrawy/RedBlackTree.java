package IE3_ADL_LAB4.com.mhelghamrawy;

import java.util.Iterator;
import java.util.Stack;

public class RedBlackTree <Key  extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private class RedBlackTreeIterator implements Iterator<Key> {
        private Stack<Node> stackOfNodes = new Stack<Node>();

        public RedBlackTreeIterator() {

            pushLeft(root);
        }

        @Override
        public boolean hasNext() {
            return !stackOfNodes.isEmpty();
        }

        @Override
        public Key next() {
            Node currentNode = stackOfNodes.pop();
            pushLeft(currentNode.right);
            //System.out.println(nodeDepth(currentNode));
            return currentNode.key;
        }

        private void pushLeft(Node currentNode) {
            while (currentNode != null) {
                stackOfNodes.push(currentNode);
                currentNode = currentNode.left;
            }
        }
    }

    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;
    private int nodeCount;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return (x.color == RED);
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.value;
            else if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
        }
        return null;
    }


    private Node put(Node h, Key key, Value val) {
        nodeCount++;
        if (h == null)
            return new Node(key, val, RED);
        if (isRed(h.left))
            if (isRed(h.left.left))
                h = splitFourNode(h);
        int cmp = key.compareTo(h.key);
        if (cmp == 0) h.value = val;
        else if (cmp < 0)
            h.left = put(h.left, key, val);
        else
            h.right = put(h.right, key, val);
        if (isRed(h.right))
            h = leanLeft(h);
        return h;
    }

    private Node leanLeft(Node h) {
        Node x = rotL(h);
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    private Node rotL(Node h) {
        Node v = h.right;
        h.right = v.left;
        v.left = h;
        return v;
    }

    private Node rotR(Node h) {
        Node u = h.left;
        h.left = u.right;
        u.right = h;
        return u;
    }

    private Node splitFourNode(Node h) {
        Node x = rotR(h);
        x.left.color = BLACK;
        return x;
    }

    public Value getOrDefault(Key key, Value defaultValue) {
        Node currentRoot = this.root;

        while(currentRoot != null) {
            int comparison = key.compareTo(currentRoot.key);
            if(comparison == 0)
                return currentRoot.value;
            else if(comparison > 0)
                currentRoot = currentRoot.right;
            else if(comparison < 0)
                currentRoot = currentRoot.left;
        }
        return defaultValue;
    }

    public Iterator<Key> iterator() {
        return new RedBlackTreeIterator();
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
        return maxTreeDepth(root)-maxTreeDepth(node)+1;
    }
}
