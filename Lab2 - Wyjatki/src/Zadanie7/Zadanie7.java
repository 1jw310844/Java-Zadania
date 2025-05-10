package Zadanie7;

import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Podaj działanie (np. 3 + 4): ");
        String expression = input.nextLine();

        try {
            String[] tablica = expression.split(" ");

            if (tablica.length != 3) {
                System.out.println("Niepoprawny format wejściowy. Oczekiwano formatu: liczba operator liczba.");
                return;
            }
            int num1 = Integer.parseInt(tablica[0]);
            String operator = tablica[1];
            int num2 = Integer.parseInt(tablica[2]);

            int result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Błąd: Nie można dzielić przez zero.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Nieznany operator. Dostępne operatory to: +, -, *, /.");
                    return;
            }

            System.out.println("Wynik: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Błąd: Wprowadzono niepoprawną liczbę.");
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        input.close();
    }
}
