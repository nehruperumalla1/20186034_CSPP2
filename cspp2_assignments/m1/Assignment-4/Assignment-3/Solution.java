import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }
    /**
     * Calculates the from degrees to farenheit.
     *
     * @param      degreesCelsius  The degrees celsius
     */
    static void calculateFromDegreesToFarenheit(final double degreesCelsius) {
        double degreesfahren = ((degreesCelsius * 1.8) + 32);
        System.out.println(degreesfahren);
    }
}
