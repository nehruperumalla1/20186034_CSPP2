/**
 * Sum of two matrices.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class.
 */
public final class Solution {
    private static Scanner sc = new Scanner(System.in);
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Constructor.
    }
    /* Fill the main function to print resultant of addition of matrices*/
    /**
     * Main FUnction.
     * @param args Argument.
     */
    public static void main(final String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix1 = matrix(m, n);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] matrix2 = matrix(x, y);
        int[][] sumMatrix = new int[m][n];
        if ((m != x) || (n != y)) {
            System.out.println("not possible");
        } else {

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 1; j++) {
                    System.out.print(sumMatrix[i][j] + " ");
                }
                System.out.println(sumMatrix[i][n - 1]);
            }
        }
    }
    /**
     * { function_description }.
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] matrix(final int m, final int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
}