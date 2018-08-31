/**
 * Reverse.
 * @author     Nehru.
 */
import java.util.Scanner;
/**
 * Class Solution.
 */
public final class Solution {
    /**
     * Not a Constructor.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    //Write reverseString function
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static String reverseString(final String s) {
        String new1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            new1 += s.charAt(i);
        }
        return new1;
    }

}
