/**
 * Set Solution.
 * @author Nehru Perumalla.
 */
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "addAll":
                String[] stringArray = tokens[1].split(",");
                int[] intarray = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    intarray[i] = Integer.parseInt(stringArray[i]);
                }
                s.addAll(intarray);
                break;
                case "add":
                int value = Integer.parseInt(tokens[1]);
                s.add(value);
                break;
                case "subSet":
                String[] values = tokens[1].split(",");
                if (s.subSet(Integer.parseInt(values[0]), Integer.parseInt(
                    values[1])) != null) {
                    System.out.println(s.subSet(Integer.parseInt(values[0]),
                        Integer.parseInt(values[1])));
                }
                break;
                case "headSet":
                int headvalue = Integer.parseInt(tokens[1]);
                System.out.println(s.headSet(headvalue));
                break;
                case "last":
                    System.out.println(s.last());
                break;
                default:
                break;
            }
        }
    }
}
