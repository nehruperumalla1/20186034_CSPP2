import java.util.Scanner;
import static java.lang.Math.sqrt;
public final class Solution {
    private static final int YVal = 4;
    /*
    Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsQuadraticEquation(a, b, c);
    }
    
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     */
    static void rootsQuadraticEquation(final int a, final int b, final int c) {
        double x = (-b + Math.sqrt((b * b) - y() * a * c)) / (2 * a);
        double r = a * (x * x) + b * x + c;
        double x1 = (-b - Math.sqrt((b * b) - y() * a * c)) / (2 * a);
        double r1 = a * (x1 * x1) + b * x1 + c;
        System.out.println(x + " " + x1);
    }
    static int y() {
        return YVal;
    }
}
