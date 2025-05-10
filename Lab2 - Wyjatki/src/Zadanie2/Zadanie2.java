package Zadanie2;

import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int suma = 0;
        int licznik = 0;

        System.out.println("Podaj 5 liczb całkowitych (inne wartości będą pomijane):");

        while (licznik < 5) {
            String dane = input.next();

            try {
                int liczba = Integer.parseInt(dane);
                suma += liczba;
                licznik++;
            } catch (NumberFormatException e) {
                System.out.println("Pominięto: '" + dane + "' (nie jest liczbą całkowitą)");
            }
        }

        System.out.println("Suma pięciu poprawnych liczb całkowitych wynosi: " + suma);
        input.close();
    }
}
