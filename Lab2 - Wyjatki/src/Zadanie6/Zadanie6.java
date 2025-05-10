package Zadanie6;

import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Podaj pierwszą liczbę (dzielną): ");
        String s1 = input.next();
        System.out.print("Podaj drugą liczbę (dzielnik): ");
        String s2 = input.next();

        try {
            int m = Integer.parseInt(s1);
            int n = Integer.parseInt(s2);

            if (n == 0) {
                throw new ArithmeticException("Dzielenie przez 0");
            }

            System.out.printf("%d:%d = %d r. %d\n", m, n, m / n, m % n);

        } catch (NumberFormatException e) {
            System.out.println("To nie jest liczba całkowita: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }
}
