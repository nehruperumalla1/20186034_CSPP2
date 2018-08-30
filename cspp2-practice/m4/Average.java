/**
 * { item_description }.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class for average.
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
        //Empty Constructor.
    }
    /**
     *@param args Arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println(sum / n);
    }
}
