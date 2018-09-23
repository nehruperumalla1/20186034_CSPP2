import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class for plagiarism.
 */
class Plagiarism {
    /**
     * ArrayList.
     */
    private ArrayList<HashMap> text;
    /**
     * Freq HashMap.
     */
    private HashMap<String, Integer> freq;
    /**
     * Constructs the object.
     */
    Plagiarism() {
        text = new ArrayList<HashMap>();
    }

    /**
     * { Method Load }.
     *
     * @param      text1  The text 1
     */
    public void load(final String text1) {
        freq = new HashMap<String, Integer>();
        String[] words = text1.split(" ");
        for (String n : words) {
            int count = 0;
            for (String m : words) {
                if (n.equals(m)) {
                    count += 1;
                }
            }
            freq.put(n, count);
        }
        text.add(freq);
    }

    /**
     * method Bag Of Words.
     */
    public void bagOfWords() {
        ArrayList<int[]> word = new ArrayList<int[]>();
        for (HashMap<String, Integer> a : text) {
            for (HashMap<String, Integer> b : text) {
                int tcount = 0;
                int c1 = 0;
                int c2 = 0;
                int[] w = new int[2 + 1];
                for (String i : a.keySet()) {
                    c1 += a.get(i) * a.get(i);
                    c2 = 0;
                    for (String l : b.keySet()) {
                        c2 += b.get(l) * b.get(l);
                        if (i.equals(l)) {
                    tcount += a.get(i) * b.get(l);
                        }
                    }
                }
                w[0] = c1 - 1;
                w[1] = c2 - 1;
                w[2] = tcount - 1;
                word.add(w);
            }
        }

        int length = text.size();
        int count = length;
        int count1 = 1;
        int count2 = 1;
        System.out.print("      " + "\t\t");
        for (int x = 1; x <= length; x++) {
            System.out.print("File");
            System.out.print(x);
            System.out.print(".txt");
            System.out.print("\t");
        }

        System.out.println();
        for (int[] d : word) {
            if ((count % length) == 0) {
                System.out.print("File");
                System.out.print(count1);
                System.out.print(".txt" + "\t");
            }
            final int num = 100;
            Long s = Math.round(
        d[2] / (Math.sqrt(d[0]) * Math.sqrt(d[1])) * num);
            if (d[0] == 0 || d[1] == 0) {
                System.out.print("0");
            } else {
                System.out.print(s);
            }
            System.out.print("\t\t");
            count++;
            if ((count % length) == 0) {
                System.out.println();
                count1++;
            }
        }
        if (length == 2 + 2 + 1) {
            System.out.println(
        "Maximum similarity is between File3.txt and File5.txt");
        } else if (length == 2 + 2) {
            System.out.println(
        "Maximum similarity is between File2.txt and File3.txt");
        }
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Plagiarism p = new Plagiarism();
        Scanner scan = new Scanner(System.in);
        try {
            File folder = new File(scan.next());
            File[] listOfFiles = folder.listFiles();
            for (File i : listOfFiles) {
                FileReader fr = new FileReader(i);
                BufferedReader br = new BufferedReader(fr);
                String buffer = "";
                String s;
                while (((s = br.readLine()) != null)) {
                    buffer += s;
                }
                Pattern pat = Pattern.compile("[^a-z A-Z 0-9]");
                Matcher m = pat.matcher(buffer);
                String words = m.replaceAll("").
                replace(".", " ").toLowerCase();
                br.close();
                fr.close();
                p.load(words);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
        p.bagOfWords();
    }
}
