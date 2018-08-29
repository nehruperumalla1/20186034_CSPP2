/**
 * Class for while.
 * @author     Nehru.
 */
public final class ConverttoWhileLoop {
    /**
     * Constructs the object.
     */
    private ConverttoWhileLoop() {
        //Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= 10) {
            System.out.println(i);
            i = i + 2;
        }
        System.out.println("GoodBye!");
    }
}
