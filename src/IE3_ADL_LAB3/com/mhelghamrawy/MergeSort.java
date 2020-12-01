package IE3_ADL_LAB3.com.mhelghamrawy;

public class MergeSort extends Sort{
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + 1)
            return;
        int m = lo + (hi - lo) / 2;
        sort(a, aux, lo, m);
        sort(a, aux, m, hi);
        merge(a, aux, lo, m, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int l, int m, int r) {
        for (int k = l; k < r; k++)
            copy(aux, k, a, k);

        int i = l;
        int j = m;
        for (int k = l; k < r; k++) {
            if      (i >= m)
                a[k] = aux[j++];
            else if (j >= r)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

            assert isSorted(aux, l, k);
        }
    }
}
