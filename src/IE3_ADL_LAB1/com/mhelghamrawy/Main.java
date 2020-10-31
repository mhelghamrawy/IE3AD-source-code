package IE3_ADL_LAB1.com.mhelghamrawy;

public class Main {

    public static void main(String[] args) {
        /*
        SUBMISSION
        * */
        testConvertor();

        /*
        PREPARATION
        * */
        testConstructor();
        testTokenizer();

    }

    // task 1.2.1
    private static void testConstructor() {
        ArithmeticTerm term;
        term = new ArithmeticTerm("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        ArithmeticTerm term1 = new ArithmeticTerm("4 sqrt 6 /");
        ArithmeticTerm term2 = new ArithmeticTerm("9 8.88 + 4 sqrt 6 / ^");


        System.out.println(term.toString());
        System.out.println(term1.evaluate());
        System.out.println(term2.evaluate());
        System.out.println(term.evaluate());
    }

    // task 1.2.2
    private static void testTokenizer() {
        ArithmeticTerm term1;
        term1 = new ArithmeticTerm("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");

        ArithmeticTerm term2;
        term2 = new ArithmeticTerm("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )");

        System.out.println(term1.getReversedExpression());
        System.out.println(term2.getReversedExpression());
    }

    // task 2.3
    private static void testConvertor() {
        ArithmeticTerm term1 = new ArithmeticTerm("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7  ) )");
        ArithmeticTerm term2 = new ArithmeticTerm(term1.convert());
        term2.evaluate();

        System.out.println(term2);
    }
}
