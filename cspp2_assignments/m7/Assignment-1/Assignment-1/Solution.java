/**
 * Size of String min 6.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    private final int VALUE = 6;
    /**
     * { var_description }.
     */
    private String data;
    private String length;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        this.data = input;
    }
    /**
     * { function_description }.
     *
     * @param      inputdata  The inputdata
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData(final String inputdata) {
        if ((this.data).length() >= value()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int value() {
        return VALUE;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        //Not using this.
    }
    /**
     * Main Class.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData(input));
    }
}
