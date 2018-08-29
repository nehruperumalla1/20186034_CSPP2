
import java.util.Scanner;
/**
 * GCD.
 * @author Nehru.
 */
public class Solution {
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1,n2);
        //System.out.println(gcd);
    }
	/**
	 * { function_description }.
	 *
	 * @param      x     { parameter_description }
	 * @param      y     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	static final void gcd(int x, int y) {
		int num = 0;
		for (int i = 1; i <= x; i++) {
			if ((x%i == 0) && (y%i == 0)) {
				num = i;
			}
		}
		System.out.println(num);
	}
}
