package actividad_02_ud3_ed;
import java.util.Scanner;
public class Main {
    // Creamos un objeto Scanner para leer datos del teclado
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;
        int opcion;
        // Creamos una cuenta de ejemplo con nombre, numero, saldo y tipo de interes
        cuenta1 = new CCuenta("Juan Lopez", "1000-2365-85-123456789", 2500, 0);
        // Bucle del menu principal
        do {
            // Mostramos el menu bonito
            System.out.println("\n==============================");
            System.out.println("       MENU DE OPERACIONES     ");
            System.out.println("==============================");
            System.out.println("1 - Ingresar dinero");
            System.out.println("2 - Retirar dinero");
            System.out.println("3 - Salir del programa");
            System.out.print("\nElige una opcion: ");

            // Leemos la opcion del usuario
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1 -> {
                    // Pedimos la cantidad a ingresar
                    System.out.print("\nCuanto desea ingresar?: ");
                    float cantidadIngresar = teclado.nextFloat();
                    operativa_cuenta(cuenta1, cantidadIngresar, opcion);
                }
                case 2 -> {
                    // Pedimos la cantidad a retirar
                    System.out.print("\nCuanto desea retirar?: ");
                    float cantidadRetirar = teclado.nextFloat();
                    operativa_cuenta(cuenta1, cantidadRetirar, opcion);
                }
                case 3 -> System.out.println("\nSaliendo del programa...");

                default -> // Mensaje si el usuario pone una opcion incorrecta
                    System.out.println("\nOpcion no valida, intenta de nuevo.");
            }
        } while (opcion != 3);
        // Al finalizar mostramos el saldo actual
        saldoActual = cuenta1.estado();
        System.out.println("\n--------------------------------");
        System.out.println("El saldo actual es: " + saldoActual + " euros");
        System.out.println("--------------------------------\n");
    }
    /**
     * Metodo auxiliar que realiza el ingreso o retiro segun la opcion elegida.
     * opcion 1 = ingresar
     * opcion 2 = retirar
     * @param cuenta1
     * @param cantidad
     * @param opcion
     */
    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) {  
            // Retirar dinero
            try {
                cuenta1.retirar(cantidad);
                System.out.println("\nRetiro realizado correctamente.");
                System.out.println("Saldo actual: " + cuenta1.estado() + " euros");
            } catch (Exception e) {
                System.out.println("\nError: no se pudo retirar el dinero.");
            }
        } else if (opcion == 1) {  
            // Ingresar dinero
            try {
                cuenta1.ingresar(cantidad);
                System.out.println("\nIngreso realizado correctamente.");
                System.out.println("Saldo actual: " + cuenta1.estado() + " euros");
            } catch (Exception e) {
                System.out.println("\nError: no se pudo ingresar el dinero.");
            }
        }
    }
}
