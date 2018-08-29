import java.util.Scanner;
/**
 * Sum of N Natural Number.
 * @author     Nehru.
 */
public final class SumOfNNumbers {
    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {
        //Constructor.
    }
    /**
     *
     *@param args Arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
