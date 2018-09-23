import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
/**
 * Class for string match.
 */
class StringMatch {
    /**
     * Hashmap.
     */
    private HashMap<String, Integer> freqWords = new HashMap<>();
    /**
     * String 1.
     */
    private String str1 = "";
    /**
     * String 2.
     */
    private String str2 = "";
    /**
     * Result.
     */
    private double result;
    /**
     * Constructs the object.
     *
     * @param      file1  The file 1
     * @param      file2  The file 2
     */
    StringMatch(final File file1, final File file2) {
        try {
            Scanner scan = new Scanner(file1);
            while (scan.hasNext()) {
                str1 += scan.nextLine();
            }
            scan = new Scanner(file2);
            while (scan.hasNext()) {
                str2 += scan.nextLine();
            }
            String str = "";
            for (int i = 0; i < str2.length(); i++) {
                for (int j = i + 1; j <= str2.length(); j++) {
                    if (str1.contains(str2.substring(i, j))) {
                        if (str2.substring(i, j).length() > str.length()) {
                            str = str2.substring(i, j);
                        }
                    }
                }
            }
            if (file1.getName().equals(file2.getName())) {
                result = Math.pow(2 * 2 * 2 + 2, 2);
                System.out.format("%13.1f", result);
            } else {
                double nmr = str.length() * 2 * Math.pow(2 * 2 * 2 + 2, 2);
                double dnm = str1.length() + str2.length();
                result = Math.round(nmr / dnm);
                System.out.format("%13.1f", result);
            }
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
    }
    /**
     * Gets the similarity.
     *
     * @return     The similarity.
     */
    public double getSimilarity() {
        return result;
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
        //Not Using the Constructor.
    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            File folder = new File(str);
            File[] listOfFiles = folder.listFiles();
            double max = 0;
            String file1 = "";
            String file2 = "";
            System.out.print("             ");
            for (int i = 0; i < listOfFiles.length - 1; i++) {
                System.out.print(listOfFiles[i].getName() + "    ");
            }
            System.out.print(listOfFiles[listOfFiles.length - 1].
                getName() + " ");
            System.out.println();
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.print(listOfFiles[i].getName());
                for (int j = 0; j < listOfFiles.length; j++) {
                    StringMatch sm = new StringMatch(listOfFiles[i],
                        listOfFiles[j]);
                    double s = sm.getSimilarity();
                    if (s > max && !listOfFiles[i].getName().
                        equals(listOfFiles[j].getName())) {
                        max = s;
                        file1 = listOfFiles[i].getName();
                        file2 = listOfFiles[j].getName();
                    }
                }
                System.out.print(" ");
                System.out.println();
            }
            System.out.println("Maximum similarity is between " + file1
                + " and " + file2);
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
    }
}
