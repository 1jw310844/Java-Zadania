package Zadanie8;

import java.util.Scanner;

public class Zadanie8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj pierwszą przyprostokątną: ");
        double a = sc.nextDouble();
        System.out.print("Podaj druga przyprostokątną: ");
        double b = sc.nextDouble();

        double c = (a*a) + (b*b);
        System.out.println("Wynik dla: a=" + a + " b=" + b + " to: " + c);
        sc.close();
    }
}
