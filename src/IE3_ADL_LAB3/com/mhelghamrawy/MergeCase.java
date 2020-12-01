package IE3_ADL_LAB3.com.mhelghamrawy;

public class MergeCase extends UseCase{
    public int comparisonOperations;
    public int copyOperations;
    /**
     * Constructor for objects of class UseCase
     */
    public MergeCase(InputCase inputCase, int size) {
        super(inputCase, size);
    }

    @Override
    public String toString() {
        return "Sorting method, " + super.toString();
    }

    @Override
    public void sortAndCount() {
        MergeSort.sort(this.array);
        this.comparisonOperations = Sort.comparisonOperations;
        this.copyOperations = Sort.copyOperations;
    }
}
