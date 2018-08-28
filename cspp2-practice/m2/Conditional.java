/**
 * If - Else Conditional.
 * @author     Nehru.
 */
/**
 * Class for conditional.
 */
public final class Conditional {
    /**
     * { var_description }.
     */
    private static final int VARA = 10;
    /**
     * { var_description }.
     */
    private static final int VARB = 15;
    /**
     * Not Using this Constructor.
     */
    private Conditional() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        if (vara() > varb()) {
            System.out.println("Bigger");
        } else if (vara() == varb()) {
            System.out.println("Equal");
        } else {
            System.out.println("Smaller");
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int vara() {
        return VARA;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int varb() {
        return VARB;
    }
}
