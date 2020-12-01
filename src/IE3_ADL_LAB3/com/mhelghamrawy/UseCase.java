package IE3_ADL_LAB3.com.mhelghamrawy;

import java.util.Random;

public abstract class UseCase {
    public static final int seedValue = 9139164;
    public static final int kMax = 13;
    public static final int Nmax = (int) Math.round(Math.pow(2, kMax));
    public static final int M = 20;

    // instance variables
    protected Comparable[] array;
    private InputCase inputCase;
    private int size;
    private int iterations; // for averaging a sample
    protected int comparisonOperations;
    protected int copyOperations;

    abstract void sortAndCount();

    public UseCase(InputCase inputCase, int size) {
        // initialise instance variables
        this.size = size;
        this.inputCase = inputCase;
        this.array = new Comparable[size];

        if (inputCase == InputCase.AVG){
            iterations = M;
        }
        else {
            iterations = 1;
        }

        switch(inputCase){
            case SORTED:
                initAscending();
                break;
            case REVERSE:
                initDescending();
                break;
            case RANDOM:
            case AVG:
                initRandom();
                break;
            default:
                throw new IllegalStateException("Please enter a valid Input Case!");
        }
    }

    public static void makeTable(String sortCase) { //MergeSort
        for (InputCase tableCase: InputCase.values()){ // SORTED, REVERSE, RANDOM, AVG
            int N = 1;

            System.out.println(tableCase + " case:");
            System.out.println("N                                #(cmp)                         #(copies)                            ");
            String format = "";

            for(int k=1; k<=kMax; k++){
                N*= 2;
                UseCase useCase;

                if (sortCase.equals("MergeCase")) {
                    useCase = new MergeCase(tableCase, N);
                }
                // check for all sort cases and instantiate them accordingly!
                else if(sortCase.equals("SelectionCase")){
                    useCase = new SelectionCase(tableCase, N);
                }
                else {
                    throw new IllegalStateException("Please enter a valid Sort Case!");
                }

                if(useCase != null) {
                    useCase.writeResults(format);
                }
            }
        }
    }

    private void initAscending() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = i;
        }
    }

    private void initDescending() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = this.array.length-i;
        }
    }

    private void initRandom() {
        Random rand = new Random(seedValue);
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = rand.nextInt(1000);
        }
    }

    public String getResults(String format) {
        sortAndCount();
        String results = "";
        System.out.printf("                          ,%-12d                    ,%-12d                       " ,Sort.comparisonOperations, Sort.copyOperations);
        resetCounts();
        return results;
    }

    public void writeResults(String format) {
        System.out.print (size + " "); // first part of suitable format
        format= format.substring(0);   // skip part consumed
        System.out.println(getResults(format));
    }

    public static void resetCounts() {
        // reset counts
        Sort.comparisonOperations = 0;
        Sort.copyOperations = 0;
    }

    public static void main(String[] args) {
        makeTable("MergeCase");
        makeTable("SelectionCase");
    }
}
