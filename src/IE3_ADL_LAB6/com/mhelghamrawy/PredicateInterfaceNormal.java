package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.function.Predicate;

public class PredicateInterfaceNormal {
    public static void main(String[] args)
    {
        Predicate<Integer> equalTo = number -> number == 4;
        System.out.println(equalTo.test(3));
        System.out.println(equalTo.test(4));

        Predicate<String> notEqual = inputLine -> !inputLine.equals("Drink Water");
        System.out.println(notEqual.test("Drink Soda"));

        Predicate<Character> greaterThan = c -> c > 'A';
        System.out.println(greaterThan.test('B'));
    }
}
