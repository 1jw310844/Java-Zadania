package Zadanie7;

import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        double temperatura;
        System.out.print("Wpisz temperaturę w stopniach Celsjusza: ");
        Scanner input = new Scanner(System.in);

        if (input.hasNextDouble()) {
            temperatura = input.nextDouble();

            double fahrenheit = temperatura * 1.8 + 32;
            System.out.printf("Temperatura %.1f\u00B0C to %.1f\u00B0F\n", temperatura, fahrenheit);
        } else {
            System.out.println("Błąd: Wprowadzono nieprawidłową wartość.");
        }

        input.close();
    }
}
