package IE3_ADL_LAB2.com.mhelghamrawy;

public class StackOfDoubles {
    private Double[] s;
    private int N;

    {
        N = 0;
    }

    public StackOfDoubles() {
        s = new Double[1];
    }

    public StackOfDoubles(int capacity) {
        s = new Double[capacity];
    }

    public void push(double newOperand) {
        if (N >= s.length) { dynamicResizing(2*N); }
        s[N++] = newOperand;
    }

    public double pop() {
        Double operand = s[--N];
        s[N] = null;

        if (N == s.length/4) { dynamicResizing(s.length/2); }

        return operand;
    }

    public void dynamicResizing(int max) {
        Double[] dup = new Double[max];
        for (int i = 0; i < N; i++) { dup[i] = s[i]; }
        s = dup;
    }

    public boolean isEmpty() { return N == 0; }
}
