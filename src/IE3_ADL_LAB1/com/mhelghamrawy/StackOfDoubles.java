package IE3_ADL_LAB1.com.mhelghamrawy;

public class StackOfDoubles {
    private Node first = null;

    private class Node {
        double operand;
        Node nextNode;
    }

    public void push(double newOperand) {
        Node second = first;
        first = new Node();
        first.operand = newOperand;
        first.nextNode = second;
    }
    public double pop() {
        try {
            double poppedOperand = first.operand;
            first = first.nextNode;
            return poppedOperand;
        } catch(Exception e) {
            throw new IllegalStateException("Incorrect number of arguments given.");
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
}
