/**
 * In questa classe vengono scritte dei metodi che verranno poi richiamati nel Main
 * I metodi sono:
 *      -leggiStringa (serve per leggere una parola)
 *      -leggiIntero (serve per leggere i numeri interi)
 */

import java.util.Scanner;

public class Appoggio {
    private static Scanner lettore = new Scanner(System.in);
    private static int numeroIntero;


    //Serve a leggere una Stringa e non c'è controllo (da aggiungere)
    public static String leggiStringa (String messaggio) {
        System.out.print(messaggio);
        return lettore.nextLine();
    }

    //Sereve per leggere un numero intero e non c'è controllo (da aggiungere)
    public static int leggiIntero (String messaggio) {
        System.out.print(messaggio);
        numeroIntero = lettore.nextInt();
        lettore.nextLine();
        return  numeroIntero;
    }
}
