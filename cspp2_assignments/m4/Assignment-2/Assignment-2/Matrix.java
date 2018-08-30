/**
 * Sum of two matrices.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class.
 */
public final class Matrix {
    /**
     * Constructs the object.
     */
    private Matrix() {
        //Empty Constructor.
    }
    /* Fill the main function to print resultant of addition of matrices*/
    /**
     * Main FUnction.
     * @param args Argument.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix1 = matrix(sc);
        int[][] matrix2 = matrix(sc);
        int m = matrix1.length;
        int n = matrix1[0].length;
        int x = matrix2.length;
        int y = matrix2[0].length;
        if ((m != x) || (n != y)) {
            System.out.println("not possible");
        } else {
            int[][] sumMatrix = new int[m][n];
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
     *
     * @param      sc    The scanner object     *
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] matrix(Scanner sc) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
}
