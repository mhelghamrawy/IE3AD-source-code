package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.HashMap;

public class Hash {
    public static HashMap<Character, Integer> table = new HashMap<>();

    public static int getHash(String input) {
        table.put('_', 0);
        table.put('a',	1);
        table.put('b',	2);
        table.put('c',	3);
        table.put('d',	4);
        table.put('e',	5);
        table.put('f',	6);
        table.put('g',	7);
        table.put('h',	8);
        table.put('i',	9);
        table.put('j',	10);
        table.put('k',	11);
        table.put('l',	12);
        table.put('m',	13);
        table.put('n',	14);
        table.put('o',	15);
        table.put('p',	16);
        table.put('q',	17);
        table.put('r',	18);
        table.put('s',	19);
        table.put('t',	20);
        table.put('u',	21);
        table.put('v',	22);
        table.put('w',	23);
        table.put('x',	24);
        table.put('y',	25);
        table.put('z',	26);
        table.put('A',	27);
        table.put('B',	28);
        table.put('C',	29);
        table.put('D',	30);
        table.put('E',	31);
        table.put('F',	32);
        table.put('G',	33);
        table.put('H',	34);
        table.put('I',	35);
        table.put('J',	36);
        table.put('K',	37);
        table.put('L',	38);
        table.put('M',	39);
        table.put('N',	40);
        table.put('O',	41);
        table.put('P',	42);
        table.put('Q',	43);
        table.put('R',	44);
        table.put('S',	45);
        table.put('T',	46);
        table.put('U',	47);
        table.put('V',	48);
        table.put('W',	49);
        table.put('X',	50);
        table.put('Y',	51);
        table.put('Z',	52);

        // hash function control variables
        int a = 13;
        int M = 31;

        char[] inputCharArray = input.toCharArray();

        int n = 0;
        int output = 0;

        for(int i = inputCharArray.length - 1; i >= 0; i--) {
            output = output + (table.get(inputCharArray[i]) * modPower(53, n, M));
            n++; // increment n to move to next least significant digit
        }

        return (13%31) * output;
    }

    private static int modPower(int base, int exponent, int modulus) {
        if(modulus == 1) {return 0;}

        int result = 1;
        base = base % modulus;

        while(exponent > 0) {
            if((exponent % 2) == 1) {result = (result * base) % modulus;}
            exponent = exponent / 2;
            base = (base * base) % modulus;

        }

        return result;
    }
}
