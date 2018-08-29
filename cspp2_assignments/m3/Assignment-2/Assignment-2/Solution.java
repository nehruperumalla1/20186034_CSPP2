import java.util.Scanner;
/**
 * Count of 7 upto n Numbers.
 * @author Nehru.
 */
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        char num = '7';
        for (int i = 1; i <= n; i++) {
            String str = "";
            str = str + i;
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == num) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
