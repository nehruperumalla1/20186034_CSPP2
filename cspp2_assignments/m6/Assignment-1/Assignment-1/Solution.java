import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
	// write your code here
    	int a = 1;
    	int c = 0;
    	int count = 0;
    	while (a < n) {
    		count = 0;
    		for (int i = 1; i <=a; i++) {
    			if (a % i == 0) {
    				count += 1;
    			}
    		}
    		if (count > 2) {
    			if (a % 2 != 0) {
    				System.out.println(a);
    			}
    		}
    		a += 1;
    	}
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

