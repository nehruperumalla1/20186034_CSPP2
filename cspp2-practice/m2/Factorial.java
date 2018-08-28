/**
 * Factorial of a Number.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class for factorial.
 */
public final class Factorial {
    /**
     * Constructs the object.
     */
    private Factorial() {
        //Empty Constructor.
    }
    /**
     * Main Function.
     *
     * @param      args  Arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(facto(num));
    }
    /**
     * { function_description }.
     *
     * @param      n     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static int facto(final int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * facto(n - 1);
        }
    }
}
