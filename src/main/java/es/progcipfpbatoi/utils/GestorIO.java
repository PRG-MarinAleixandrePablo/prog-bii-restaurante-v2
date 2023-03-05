package es.progcipfpbatoi.utils;

import java.util.Scanner;

public class GestorIO {

       private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int getInt(String mensaje) {
        do {
            System.out.print(mensaje + " : ");
            if (!scanner.hasNextInt()) {
                System.out.print("Debe introducir un entero");
                scanner.next();
            } else {
                int leido =  scanner.nextInt();
                limpiarBuffer();
                return leido;
            }
        } while (true);
    }



    public static String getString(String mensaje) {
        System.out.print(mensaje + " : ");
        return scanner.nextLine();
    }



    private static void limpiarBuffer() {
        scanner.nextLine();
    }
}