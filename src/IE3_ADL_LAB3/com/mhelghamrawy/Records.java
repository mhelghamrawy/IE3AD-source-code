package IE3_ADL_LAB3.com.mhelghamrawy;

import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Class Records: 
 * Test of stability of divers sorting algorithms.<br>
 *
 * @author Mohamed ElGhamrawy, based on code by Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class Records
{
    // size for stable sort tests in main program:
    private final static int N= 8;  
    // instance variables - replace the example below with your own
    private final int size;
    private Record[] recs;
    private List<Record> list;

    /**
     * Constructor for objects of class Records
     */
    public Records(int size) {
        // initialise instance variables
        this.size=size;
        recs= new Record[size];
        init();
    }

    private void init() {
        for (int i=0; i<size; i++){
            recs[i] = new Record(new Integer(i/4),"o"+i);
        }
        list= Arrays.asList(recs);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }

    public void shuffle() {
        Collections.shuffle(list, new Random(System.currentTimeMillis()));
        recs= list.toArray(recs); // not required, why?
    }

    public void insertionSort() {
        Insertion.sort(recs);
        list= Arrays.asList(recs); // not required, why?
    }

    public void selectionSort() {
        Selection.sort(recs);
        list= Arrays.asList(recs); // not required, why?
    }

    public static void main(String[] a) {
        Integer[] b = new Integer[] {1, 2, 3, 5};

        Sort.isSorted(b, 0, 3);

//        Records recs= new Records(N);
//        System.out.println( recs);
//
//        System.out.println("\n Stable Sort Test for Insertion Sort:");
//        recs.shuffle();
//        System.out.println( recs);
//        recs.insertionSort();
//        System.out.println( recs);
//
//        System.out.println("\n Stable Sort Test for Selection Sort:");
//        recs.shuffle();
//        System.out.println( recs);
//        recs.selectionSort();
//        System.out.println( recs);
    }
}
