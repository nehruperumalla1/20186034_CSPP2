import java.util.Scanner;
import java.util.Arrays;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

	// write your code here
    	int num = 0;
    	int count = 0;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++) {
    			count = 0;
    			num = a[i][j];
    			while (num > 100) {
    				num -= 100;
    				count += 1;
    			}
    			if ((100 - num) < 50) {
    				num = num + (100 - num);
    			} else {
    				num = 0;
    			} 
    			if (count > 0) {
    				while (count >= 0) {
    					num += 100;
    				}
    			}
    			a[i][j] = num;
    			System.out.println(a[i][j]);
    		}
    	}
    	return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}