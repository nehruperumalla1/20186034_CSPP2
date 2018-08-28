import java.util.Scanner;
public class Solution {
	/**
	 * Do not modify this main function.
	 */
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base,exponent);
        System.out.println(result);
	}
	/**
	 * Need to write the power function and print the output.
	 */
	static long power(int base, int exp) {
		if (exp == 1) {
			return base;
		} else if (exp == 0){
			return 1;
		} else {
			return base * power(base, exp-1);
		}
	}
}
