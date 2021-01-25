package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.function.Function;

public class FunctionInterface {

    public static void main(String[] args)
    {
        Function<Integer, Double> divideByThree = x-> (double) x / 3;
        System.out.println(divideByThree.apply(4));

        Function<Character, String> toString = c -> c.toString();
        System.out.println(toString.apply('s'));

        Function<Character, Integer> toAscii = c -> (int) c;
        System.out.println(toAscii.apply('´'));


    }
}
