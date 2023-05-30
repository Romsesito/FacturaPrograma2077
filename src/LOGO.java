public class LOGO {
    private static final String Azuh = "\u001B[34m";
    private static final String Amariyo = "\u001B[33m";
    private static final String Default = "\u001B[0m";

    public void printLogo() {
        // Primera cadena en azul
        System.out.print(Azuh + " __     __                  _ \n");
        System.out.print(" \\ \\   / /                 (_)\n");
        System.out.print("  \\ \\_/ /   _   _   _ __    _ \n");
        System.out.print("   \\   /   | | | | | '_ \\  | |\n");
        System.out.print("    | |    | |_| | | |_) | | |\n");
        System.out.print("    |_|     \\__,_| | .__/  |_|\n");
        System.out.print("                   | |        \n");
        System.out.print("                   |_|        \n" + Default);

        // Resto de cadenas en amarillo
        System.out.print(Amariyo + "  _______  __                  \n");
        System.out.print("|     __||  |--..-----..-----.\n");
        System.out.print("|__     ||     ||  _  ||  _  |\n");
        System.out.print("|_______||__|__||_____||   __|\n");
        System.out.print("                       |__|   \n" + Default);
    }
}
