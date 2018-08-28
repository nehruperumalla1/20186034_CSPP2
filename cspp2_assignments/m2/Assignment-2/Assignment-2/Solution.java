/**
 * RootsofQuadraticEquations.
 * @author     Nehru.
 */
import java.util.Scanner;
import static java.lang.Math.sqrt;
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    private static final int YVALUE = 4;
    /**
     * Not Using this Constructor.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * Do not modify this main function.
     * @param args Arguments.
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
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static int y() {

        return YVALUE;
    }
}

