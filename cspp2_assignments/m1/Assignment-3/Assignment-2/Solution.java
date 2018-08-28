/**
 * Class for solution.
 */
import java.util.Scanner;
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Constructor
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }
    /**
     * { function_description }.
     *
     * @param      base    The base
     * @param      height  The height
     */
    static void areaOfTriangle(final int base, final int height) {
        double area = 0.5 * base * height;
        System.out.println(area);
    }
}

