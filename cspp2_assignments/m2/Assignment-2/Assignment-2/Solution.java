import java.util.Scanner;
import static java.lang.Math.sqrt;
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	static void rootsOfQuadraticEquation(int a, int b, int c) {
		int y = 4;
		double x = (- b + Math.sqrt((b * b) - y * a * c)) / (2 * a);
		double r = a * (x * x) + b * x + c;
		double x1 = (- b - Math.sqrt((b * b) - y * a * c)) / (2 * a);
		double r1 = a * (x1 * x1) + b * x1 + c;
		System.out.println(x + " " + x1);
	}
}
