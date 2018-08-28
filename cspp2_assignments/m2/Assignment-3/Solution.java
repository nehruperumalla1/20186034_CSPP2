/**
 * Base and Power.
 * @author Nehru.
 */
import java.util.Scanner;
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
     * Need to write the power function and print the output.
     */
    static long power(int base, int exp) {
        if (exp == 1) {
            return base;
        } else if (exp == 0) {
            return 1;
        } else {
            return base * power(base, exp - 1);
        }
    }
}
