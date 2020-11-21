package IE3_ADL_LAB2.com.mhelghamrawy;

public class Application {

    public static void main(String[] args) {
        // REPORT
        Tree tree1 = new Tree("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        Tree tree2 = new Tree("4 pi 3 / * sin -1 2 sqrt 1 - 8 / * exp * 6 pi * sqrt / ");
        Tree tree3 = new Tree("4 sqrt 2 3 ^ * 2 /");

        System.out.println("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        tree1.postorderTraversal();
        System.out.println();
        System.out.println("4 pi 3 / * sin -1 2 sqrt 1 - 8 / * exp * 6 pi * sqrt / ");
        tree2.postorderTraversal();
        System.out.println();
        System.out.println("4 sqrt 2 3 ^ * 2 /");
        tree3.postorderTraversal();

        // PREPARATION
//
//        // Testing expanded ArithmeticTerm.convert()
//        ArithmeticTerm term0 = new ArithmeticTerm("( ( ( ( sin ( 4 * ( pi / 3 ) ) ) * ( exp ( -1 * ( ( sqrt 2 ) - 1 ) / 8 ) ) ) ) / ( sqrt ( 6 * pi ) ) )");
//        term0.convert();
//        System.out.println(term0.toString());
//        // Testing Tree.construct()
//        Tree term1 = new Tree("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
    }
}
