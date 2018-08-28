/**
 * Area of Circle.
 * @author     Nehru.
 */
import java.util.Scanner;
/**
 * Class AreaOfCircle.
 */
public final class AreaofCircle {
    /**
     * @variable PIVALUE.
     */
    private static final double PIVALUE = 22 / 7.0;
    /**
     * Empty Constructor.
     */
    private AreaofCircle() {
        // I am not using this constructor.
    }
    /**
     * Main Function.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int rad = sc.nextInt();
        System.out.println(area(rad));
    }
    /**
     * Area method to Calculate area of circle.
     * @param radius is the parameter for this method
     * @return double value of area of circle
     */
    public static double area(final int radius) {
        return (pi() * radius * radius);
    }
    /**
     * pi method to return pi value.
     * @return double value.
     */
    public static double pi() {
        return PIVALUE;
    }
}
