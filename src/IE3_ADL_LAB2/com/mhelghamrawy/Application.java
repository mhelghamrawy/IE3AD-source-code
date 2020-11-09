package IE3_ADL_LAB2.com.mhelghamrawy;

public class Application {

    public static void main(String[] args) {
        // Testing expanded ArithmeticTerm.convert()
        ArithmeticTerm term0 = new ArithmeticTerm("( ( ( ( sin ( 4 * ( pi / 3 ) ) ) * ( exp ( -1 * ( ( sqrt 2 ) - 1 ) / 8 ) ) ) ) / ( sqrt ( 6 * pi ) ) )");
        term0.convert();
        System.out.println(term0.toString());
        // Testing Tree.construct()
        Tree term1 = new Tree("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
    }
}
