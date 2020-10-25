package IE3_ADL_LAB1.com.mhelghamrawy;

import java.util.LinkedList;

public class StackOfDoubles {
    private Node first = null;

    private class Node {
        Double operand;
        Node nextNode;
    }

    public void push(Double newOperand) {
        Node second = first;
        first = new Node();
        first.operand = newOperand;
        first.nextNode = second;
    }
    public Double pop() {
        Double poppedOperand = first.operand;
        first = first.nextNode;
        return poppedOperand;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
