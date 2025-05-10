package Zadanie5;

import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą: ");

        if (input.hasNextInt()) {
            int n = input.nextInt();

            if (n == 0) {
                System.out.println("Nie istnieje odwrotność liczby 0.");
            } else {
                double odwrotnosc = 1.0 / n;
                System.out.println("Odwrotność liczby " + n + " to: " + odwrotnosc);
            }
        } else {
            String s = input.next();
            System.out.println("To nie jest liczba całkowita: " + s);
        }

        input.close();
    }
}
