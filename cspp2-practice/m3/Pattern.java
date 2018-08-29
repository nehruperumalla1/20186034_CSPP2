/**
 * Class for pattern.
 *
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
        //Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
