package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.function.Consumer;

public class ConsumerInterface {

public static void main(String[] args)
{
    Consumer<String> printTheArgument = x -> System.out.println(x);
    printTheArgument.accept("Is it printed?");
    printTheArgument.accept("Yes");

    Consumer<Integer> squareTheArgument = x -> x = x*x;
    squareTheArgument.accept(4);

    Consumer<Character> upperCase = c -> c.toString().toUpperCase();
    upperCase.accept('c');
}

}
