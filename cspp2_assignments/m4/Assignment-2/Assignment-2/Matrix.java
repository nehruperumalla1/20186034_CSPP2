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
        int[][] matrix1 = createMatrix(sc);
        int[][] matrix2 = createMatrix(sc);
        int m = getRowSize(matrix1), n = getColumnSize(matrix1);
        int x = getRowSize(matrix2), y = getColumnSize(matrix2);
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
    public static int[][] createMatrix(final Scanner sc) {
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

    /**
     * Gets the row size.
     *
     * @param      array  The array
     *
     * @return     The row size.
     */
    public static int getRowSize(final int[][] array) {
        return array.length;
    }
    
    /**
     * Gets the column size.
     *
     * @param      array  The array
     *
     * @return     The column size.
     */
    public static int getColumnSize(final int[][] array) {
        return array[0].length;
    }

}
