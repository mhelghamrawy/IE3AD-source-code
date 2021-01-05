package IE3_ADL_LAB4.com.mhelghamrawy;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        BinarySearchTree text1Bst = constructBst("/Users/mohamedelghamrawy/Library/Mobile Documents/com~apple~CloudDocs/Work/20_IE3/AD/LAB4/text1.txt");
        BinarySearchTree test2Bst = constructBst("/Users/mohamedelghamrawy/Library/Mobile Documents/com~apple~CloudDocs/Work/20_IE3/AD/LAB4/text2.txt");

        RedBlackTree text1Rbt = constructRbt("/Users/mohamedelghamrawy/Library/Mobile Documents/com~apple~CloudDocs/Work/20_IE3/AD/LAB4/text1.txt");
        RedBlackTree text2Rbt = constructRbt("/Users/mohamedelghamrawy/Library/Mobile Documents/com~apple~CloudDocs/Work/20_IE3/AD/LAB4/text2.txt");

        Iterator iterator;

        iterator = text1Bst.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    private static RedBlackTree constructRbt(String pathname) {
        RedBlackTree tree = new RedBlackTree();
        int counter = 0;

        // Try reading file, else throw error
        try {
            File file = new File(pathname);

            Scanner s = new Scanner(file);
            StringTokenizer tokenizer;
            String line;
            String token;

            while (s.hasNextLine()) {
                line = s.nextLine();
                tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    // get next token
                    token = tokenizer.nextToken();
                    counter++;
                    // remove punctuation
                    token = token.replaceAll("\\p{Punct}","");
                    // add token to tree
                    if (!token.equals("")) {
                        tree.put(token, counter);
                    }
                }
            }
        }
        catch (Exception e) {
            throw new IllegalStateException("Unable to read text files");
        }
        return tree;
    }

    private static BinarySearchTree constructBst(String pathname) {
        BinarySearchTree tree = new BinarySearchTree();
        int counter = 0;

        // Try reading file, else throw error
        try {
            File file = new File(pathname);

            Scanner s = new Scanner(file);
            StringTokenizer tokenizer;
            String line;
            String token;

            while (s.hasNextLine()) {
                line = s.nextLine();
                tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    // get next token
                    token = tokenizer.nextToken();
                    counter++;
                    // remove punctuation
                    token = token.replaceAll("\\p{Punct}","");
                    // add token to tree
                    if (!token.equals("")) {
                        tree.put(token, counter);
                    }
                }
            }
        }
        catch (Exception e) {
            throw new IllegalStateException("Unable to read text files");
        }
        return tree;
    }
}
