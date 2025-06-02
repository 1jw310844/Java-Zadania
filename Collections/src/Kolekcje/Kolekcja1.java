package Kolekcje;

import java.io.*;
import java.util.*;

public class Kolekcja1 {

    static class TytulComparator implements Comparator<Piosenka> {
        @Override
        public int compare(Piosenka p1, Piosenka p2) {
            return p1.getTytul().compareToIgnoreCase(p2.getTytul());
        }
    }

    static class ArtystaComparator implements Comparator<Piosenka> {
        @Override
        public int compare(Piosenka p1, Piosenka p2) {
            return p1.getArtysta().compareToIgnoreCase(p2.getArtysta());
        }
    }

    public static void main(String[] args) {
        List<Piosenka> listaPiosenek = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jakub\\Desktop\\Java zadania\\Collections\\src\\Kolekcje\\ListaPiosenek.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split("/");
                if (dane.length == 4) {
                    String tytul = dane[0].trim();
                    String artysta = dane[1].trim();
                    int ocena = Integer.parseInt(dane[2].trim());
                    int bpm = Integer.parseInt(dane[3].trim());

                    listaPiosenek.add(new Piosenka(tytul, artysta, ocena, bpm));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Błąd wczytywania pliku: " + e.getMessage());
        }

        System.out.println("Lista oryginalna:");
        for (Piosenka p : listaPiosenek) {
            System.out.println(p);
        }

        Collections.sort(listaPiosenek, new TytulComparator());
        System.out.println("\nLista posortowana po tytule:");
        for (Piosenka p : listaPiosenek) {
            System.out.println(p);
        }

        Collections.sort(listaPiosenek, new ArtystaComparator());
        System.out.println("\nLista posortowana po artyście:");
        for (Piosenka p : listaPiosenek) {
            System.out.println(p);
        }
    }
}
