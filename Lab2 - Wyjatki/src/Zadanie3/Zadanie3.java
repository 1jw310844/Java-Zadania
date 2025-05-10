package Zadanie3;

import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int suma = 0;
        int licznik = 0;

        System.out.println("Podaj 5 liczb całkowitych (inne wartości zostaną zignorowane):");

        while (licznik < 5) {
            if (input.hasNextInt()) {
                int liczba = input.nextInt();
                suma += liczba;
                licznik++;
            } else {
                String token = input.next();
                System.out.println("Pominięto: '" + token + "' (nie jest liczbą całkowitą)");
            }
        }

        System.out.println("Suma pięciu poprawnych liczb całkowitych wynosi: " + suma);
        input.close();
    }
}