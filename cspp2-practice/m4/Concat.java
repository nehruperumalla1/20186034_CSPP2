import java.util.Scanner;
/**
 * Class for concatenate.
 * @author     Nehru.
 */
public final class Concat {
    /**
     * Not using this COnstructor.
     */
    private Concat() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Hello " + s + "!");
    }
}
