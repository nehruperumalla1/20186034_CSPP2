import java.util.Scanner;
/**
 * Base and Power.
 * @author Nehru.
 */
public final class Solution {
    /**
     * Empty Constructor.
     */
    private Solution() {
        // Empty Constructor.
    }
    /**
     * Do not modify this main function.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
     * { function_description }.
     *
     * @param      base  The base.
     * @param      exp   The exponent.
     *
     * @return     { description_of_the_return_value }
     */
    static long power(final int base, final int exp) {
        if (exp == 1) {
            return base;
        } else if (exp == 0) {
            return 1;
        } else {
            return base * power(base, exp - 1);
        }
    }
}
