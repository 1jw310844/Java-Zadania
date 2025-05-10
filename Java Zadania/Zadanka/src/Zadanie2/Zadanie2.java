package Zadanie2;

public class Zadanie2 {
    public static void main(String[] args) {
        System.out.println("Zadania z programowania."); //Zwykły napis
        System.out.println("Zadania z programowania.".charAt(0)); //Pierwsza litera napisu (indeksowane od zera)
        System.out.println("Zadania z programowania.".length()); //Długość ciągu znakowego wliczając spacje
        System.out.println("Zadania z programowania.".charAt(23)); //24 litera ciągu znakowego
        System.out.println("Zadania z programowania.".toUpperCase()); //Wszystkie duże litery
        System.out.println("Zadania z programowania.".toLowerCase()); //Wszystkie małe litery
        System.out.println("Zadania z programowania.".indexOf('z')); //Pod którym indeksem znajduje się litera 'z'
        System.out.println("Zadania z programowania.".indexOf("prog")); //Pod którym indeksem zaczyna się ciąg 'prog'
        System.out.println("Zadania z programowania.".replace('.','?')); //Zamiana kropki na '?'
        System.out.println("Zadania z programowania.".replace("adania","dania")); // Również zamiana ale tekstu
        System.out.println("Zadania z programowania.".replaceAll("ania","anka")); //Zamiana tekstu w każdym wypadku wystąpienia tego ciągu
        System.out.println("Zadania z programowania.".replaceFirst("ania","anka")); //Zamiana pierwszego wystąpienia podanego ciągu
        System.out.println("Zadania z programowania.".substring(10)); //Wyswietlenie znakow od 10 indeksu
        System.out.println("Zadania z programowania.".substring(10,17)); //Wyswietlenie znakow miedzy 10 a 17 indeksem wlacznie
        System.out.println("Zadania z programowania.".concat("\b z podpowiedziami.")); //Konkatenacja czyli dodanie tekstu do ciagu znakowego
        System.out.println("Zadania z programowania."+"\b"+" z odpowiedziami."); //Konkatenacja ale uzywajac znaku '+'
    }
}
