/**
 * { item_description }.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class FirstLast6.
 */
public final class FirstLast6 {
    /**
     * { var_description }.
     */
    private static final int NUM = 6;
    /**
     * Constructs the object.
     */
    private FirstLast6() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println((arr[0] == num()) || (arr[n - 1] == num()));
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int num() {
        return NUM;
    }
}
