/**
 * Binary to Decimal.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Not using Costructor.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            long res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static long binaryToDecimal(final String s) {
        double result = 1;
        int sum = 0;
        int base = 2;
        int k = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = Math.pow(2, k);
                sum += result;
            }
            k = k - 1;
        }
        return sum;
    }

}
