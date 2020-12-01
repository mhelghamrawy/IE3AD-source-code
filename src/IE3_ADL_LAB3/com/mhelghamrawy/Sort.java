package IE3_ADL_LAB3.com.mhelghamrawy;

/**
 * Abstract class Sort is responsible for operations and their counting.
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public abstract class Sort {
    public static int copyOperations = 0;
    public static int comparisonOperations = 0;

    protected static void exch(Comparable[] a, int i, int j) {
        copyOperations++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static boolean less(Comparable v, Comparable w) {
        comparisonOperations++;
        return (v.compareTo(w) < 0);
    }

    public static boolean isSorted(Comparable[] a, int left, int right) {
        boolean answer = true;

        Comparable[] subarray = new Comparable[right-left]; // declare a new array to hold subarray to be tested
        System.arraycopy(a, left, subarray, 0, right-left); // copy elements from array into subarray

        // Test if subarray is sorted
        for(int i = 0; i < subarray.length; i++) {
            Comparable element = subarray[i];
            Comparable nextElement = subarray[i+1];
            if(less(element, nextElement)) {
                 continue;
            }
            else
                answer = false;
        }
        return answer;
    }

    protected static boolean isPartitioned(Comparable a[], int left, int border, int right)
    {
        Comparable[] firstPartArray = new Comparable[border-left+1];
        Comparable[] secondPartArray = new Comparable[right-border+1];
        Comparable maxOfFirstPartArray = 0;
        System.arraycopy(a, left, firstPartArray, 0, border-left);
        System.arraycopy(a, border, secondPartArray, 0, right-border);
        for(int i = 0; i < border-left; i++)
        {
            if(less(maxOfFirstPartArray, firstPartArray[i]))
            {
                maxOfFirstPartArray =  firstPartArray[i];
            }
            else
                continue;
        }
        for(int i = 0; i < right - border; i++)
        {
            if(less(maxOfFirstPartArray,secondPartArray[i]))
                continue;
            else
                return false;
        }
        return true;
    }

    protected static void copy(Comparable[] dest, int i, Comparable[] source, int j) {
        dest[i] = source[i];
        copyOperations++;
    }
}
