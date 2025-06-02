package Kolekcje;

import java.io.*;
import java.util.*;

public class Kolekcja2 {
    public static void main(String[] args) {
        List<Piosenka> listaZPowtorzeniami = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jakub\\Desktop\\Java zadania\\Collections\\src\\Kolekcje\\PelnaListaPiosenek.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split("/");
                if (dane.length == 4) {
                    String tytul = dane[0].trim();
                    String artysta = dane[1].trim();
                    int ocena = Integer.parseInt(dane[2].trim());
                    int bpm = Integer.parseInt(dane[3].trim());

                    listaZPowtorzeniami.add(new Piosenka(tytul, artysta, ocena, bpm));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Błąd podczas wczytywania pliku: " + e.getMessage());
        }

        System.out.println("Lista z powtórzeniami:");
        for (Piosenka p : listaZPowtorzeniami) {
            System.out.println(p);
        }

        Set<Piosenka> unikalnePiosenki = new HashSet<>(listaZPowtorzeniami);

        System.out.println("\nZbiór unikalnych piosenek:");
        for (Piosenka p : unikalnePiosenki) {
            System.out.println(p);
        }

        List<Piosenka> listaPosortowana = new ArrayList<>(unikalnePiosenki);
        listaPosortowana.sort(Comparator.comparing(Piosenka::getTytul));

        System.out.println("\nUnikalne piosenki posortowane po tytule:");
        for (Piosenka p : listaPosortowana) {
            System.out.println(p);
        }
    }
}
