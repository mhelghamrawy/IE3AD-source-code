package IE3_ADL_LAB1.com.mhelghamrawy;

public class Main {

    public static void main(String[] args) {
        /*
        SUBMISSION
        * */
        testConvertor();
        testFinal();

        /*
        PREPARATION
        * */
        // testConstructor();
        // testTokenizer();

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

    // task 2.2
    private static void testFinal() {
        ArithmeticTerm term1 = new ArithmeticTerm("10 9 125.6 + 9 sqrt 6 / ^ 1 - *");
        ArithmeticTerm term2 = new ArithmeticTerm("1 9 25.6 + 2 sqrt 6 * ^ 3 + /");
        ArithmeticTerm term3 = new ArithmeticTerm("17 20 128 + 5 6 / ^ 5 - *");
        ArithmeticTerm term4 = new ArithmeticTerm("8 2 255 + 6 / ^ 5 -");
        ArithmeticTerm term5 = new ArithmeticTerm("8 25.5 + 6 / 2 ^ 5 -");

        System.out.println(term1.evaluate());
        System.out.println(term2.evaluate());
        System.out.println(term3.evaluate());
        System.out.println(term4.evaluate());
        System.out.println(term5.evaluate());
    }

    // task 2.3
    private static void testConvertor() {
        ArithmeticTerm term1 = new ArithmeticTerm("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7  ) )");
        ArithmeticTerm term2 = new ArithmeticTerm(term1.convert());
        term2.evaluate();

        System.out.println(term2);
    }
}
