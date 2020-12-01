package IE3_ADL_LAB3.com.mhelghamrawy;

public class SelectionCase extends UseCase{

    public SelectionCase(InputCase inputCase, int size) {
        super(inputCase, size);
    }

    @Override
    public String toString() {
        return "Sorting method, " + super.toString();
    }

    @Override
    void sortAndCount() {
        Selection.sort(this.array);
        this.comparisonOperations = Sort.comparisonOperations;
        this.copyOperations = Sort.copyOperations;
    }
}
