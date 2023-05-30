public class Descuento {
    private static final double DESCUENTO_0 = 0.0;
    private static final double DESCUENTO_5 = 0.05;
    private static final double DESCUENTO_7 = 0.07;
    private static final double DESCUENTO_10 = 0.10;

    public static double calcularDescuento(double subtotal) {
        if (subtotal <= 100) {
            return DESCUENTO_0;
        } else if (subtotal <= 500) {
            return DESCUENTO_5;
        } else if (subtotal <= 1000) {
            return DESCUENTO_7;
        } else {
            return DESCUENTO_10;
        }
    }

    public static double calcularTotalConDescuento(double subtotal) {
        double descuento = calcularDescuento(subtotal);
        double total = subtotal - (subtotal * descuento);
        return total;
    }
}
