package IE3_ADL_LAB2.com.mhelghamrawy;

public class Application {

    public static void main(String[] args) {
        Tree term1 = new Tree("10 9 125.6 + 9 sqrt 6 / ^ 1 - *");
        Tree term2 = new Tree("1 9 25.6 + 2 sqrt 6 * ^ 3 + /");
        Tree term3 = new Tree("17 20 128 + 5 6 / ^ 5 - *");
        Tree term4 = new Tree("8 2 255 + 6 / ^ 5 -");
        Tree term5 = new Tree("8 25.5 + 6 / 2 ^ 5 -");
    }
}
