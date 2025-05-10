package Zadanie1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double liczba;

        while (true) {
            System.out.print("Podaj liczbę zmiennoprzecinkową: ");
            try {
                liczba = input.nextDouble();
                System.out.println("Poprawnie wczytano: " + liczba);
                break;
            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba. Spróbuj ponownie.");
                input.next();
            }
        }

        input.close();
    }
}
