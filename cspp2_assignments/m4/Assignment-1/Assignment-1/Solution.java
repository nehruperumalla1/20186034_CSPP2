/**
 * Largest Num in Array.
 * @author     Nehru.
 */
import java.util.*;
public class Solution
{
	/**
	 * { function_description }.
	 * @param      args  The arguments
	 */
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int arr[] = new int[n];
		int high = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > high) {
				high = arr[i];
			}
		}
		System.out.println(high);
	}
}
