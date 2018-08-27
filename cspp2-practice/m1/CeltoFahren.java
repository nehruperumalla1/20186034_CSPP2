/**
 * Celsius to Fahrenheit.
 * @author Nehru.
 */
public final class CeltoFahren {
    /**
     * Celsius to fahrenheit.
     */
    private CeltoFahren() {
    }
    /**
     * Main Function.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        float celsius = 48.9f;
        System.out.println("Fahrenheit : " + ((celsius * 1.8) + 32));
    }
}
