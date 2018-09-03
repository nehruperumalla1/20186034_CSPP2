/**
 * Size of String min 6.
 * @author Nehru.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private String data;
    private String length;
    InputValidator(final String input) {
        this.data = input;
    }
    public boolean validateData(final String inputdata) {
        if ((this.data).length() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
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
