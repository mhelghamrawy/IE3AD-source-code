package IE3_ADL_LAB5.com.mhelghamrawy;

public class Application {
    public static void main(String[] args) {
        Huffman encoder = new Huffman("***sbl****hea*t*y*ro_");

        System.out.println(encoder.encode("she_sells_sea_shells_by_the_seashore"));
        System.out.println(encoder.encode("she_sells_sea_shells_by_the_seashore").length());


        Huffman decoder = new Huffman("***sbl****hea*t*y*ro_");
        System.out.println(decoder.decode(new StringBuffer("00010000100011100010001010100011000100011001110001000010001010100011001101101110101000010001110001000110010001000010111110111010001")));

        System.out.println(encoder.encode("selly_sells_her_shorts_by_the_seattle_store"));
        System.out.println(encoder.encode("selly_sells_her_shorts_by_the_seattle_store").length());
    }
}
