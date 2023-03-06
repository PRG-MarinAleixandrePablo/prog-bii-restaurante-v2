package es.progcipfpbatoi.utils;

import java.util.Scanner;

public class GestorIO {

       private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int obtenerEntero(String mensaje) {
        do {
            System.out.print(mensaje);
            if (!scanner.hasNextInt()) {
                AnsiColor.errorOutput("Error! Debe introducir un entero");
                scanner.next();
            } else {
                return scanner.nextInt();
            }
        } while (true);
    }

    public static String obtenerString(String mensaje) {
        System.out.print(mensaje + " : ");
        return scanner.next();
    }}
