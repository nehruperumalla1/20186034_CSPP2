/**
 * Swapping.
 * @author Nehru
 */
public final class Swap {
    /**
     * Swapping two numbers.
     */
    private Swap() {
    }
    /**
     * Main Function.
     * @param args Swapping two numbers.
     */
    public static void main(final String[] args) {
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
