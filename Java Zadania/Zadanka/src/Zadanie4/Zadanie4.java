package Zadanie4;

public class Zadanie4 {
    public static void main(String[] args) {
        System.out.println("Wybrane stałe i metody statyczne klasy Integer\n");
        System.out.println("Integer.MIN_VALUE "+Integer.MIN_VALUE); //Minimalna dopuszczalna wartość
        System.out.println("Integer.MAX_VALUE "+Integer.MAX_VALUE); //Maksymalna dopuszczalna wartość
        System.out.println("Integer.SIZE "+Integer.SIZE); //Rozmiar Integera
        int a=179; //Definicja zmiennej a z przypisaną wartością 179
        System.out.println("a= "+a); //Wypisanie na ekran ciagu "a" i + czyli konkatenacja zmiennej a
        System.out.println("Integer.toBinaryString(a) "+Integer.toBinaryString(a)); //Binarny zapis liczby 179
        System.out.println("Integer.toOctalString(a) "+Integer.toOctalString(a)); //Osemkowy zapis liczby 179
        System.out.println("Integer.toHexString(a) "+Integer.toHexString(a)); // Szesnastkowy zapis liczby 179
        System.out.println("Integer.toString(a) "+Integer.toString(a));// w systemie 10 Zamienia liczbę całkowitą a na tekst w systemie dziesiętnym
        System.out.println("Integer.toString(a,4) "+Integer.toString(a,4));// w systemie 4 Zamienia a na tekst reprezentujący jego wartość w systemie czwórkowym
        int b=Integer.parseInt("-177"); //Konwertuje łańcuch tekstowy "-177" na liczbę całkowitą.
        System.out.println("b= "+b);
        int c=Integer.parseInt("1000",8);//Konwertuje liczbę zapisaną jako tekst "1000" z systemu ósemkowego (podstawa 8) na dziesiętny
        System.out.println("c= "+c);
        System.out.println("Integer.signum(a) "+Integer.signum(a));//znak liczby
        System.out.println("Integer.signum(b) "+Integer.signum(b));
        System.out.println("Integer.signum(0) "+Integer.signum(0));

        //Integer sigmum zwraca 1 jesli liczba dodatnia, -1 jesli ujemna i 0 jesli jest rowna 0
    }
}
