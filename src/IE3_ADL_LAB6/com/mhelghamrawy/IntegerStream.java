package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStream {
    public Stream<Integer> generateIntegerStream(int n) {
        return IntStream.range(0, n).boxed();
    }

    public Stream<Integer> generateAnotherIntegerStream(int n) {
        return Stream.iterate(0, x -> x + 1).limit(n);
    }

    public IntStream generateOneMoreIntegerStream(int n) {
        int[] arrayOfIntegers = new int[n];
        for (int i = 0; i < n; i++) {
            arrayOfIntegers[i] = i;
        }

        return Arrays.stream(arrayOfIntegers).distinct();
    }

    public static void main(String[] args) {
        IntegerStream stream = new IntegerStream();
        int sum1 = stream.generateIntegerStream(20).reduce(0, Integer::sum);
        int sum2 = stream.generateAnotherIntegerStream(20).mapToInt(Integer::intValue).sum();
        int sum3 = stream.generateOneMoreIntegerStream(20).sum();

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

}
