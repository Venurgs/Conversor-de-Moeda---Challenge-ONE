package conversorMonedas;

import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner;
    private CurrencyConverter converter;

    public UserInteraction(CurrencyConverter converter) {
        this.scanner = new Scanner(System.in);
        this.converter = converter;
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n*** Conversor de Monedas ***");
            System.out.println("1) USD → BRL");
            System.out.println("2) USD → EUR");
            System.out.println("3) USD → GBP");
            System.out.println("4) USD → JPY");
            System.out.println("5) USD → CAD");
            System.out.println("6) USD → AUD");
            System.out.println("7) USD → MXN");
            System.out.println("8) Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 8) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            String[] monedas = {"BRL", "EUR", "GBP", "JPY", "CAD", "AUD", "MXN"};
            double resultado = converter.convertirMoneda(monedas[opcion - 1], monto);
            System.out.println("Monto convertido: " + resultado + " " + monedas[opcion - 1]);
        }
    }
}