package Kolekcje;

import java.io.*;
import java.util.*;

public class Kolekcja3 {
    public static void main(String[] args) {
        List<Piosenka> listaZPliku = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jakub\\Desktop\\Java zadania\\Collections\\src\\Kolekcje\\PelnaListaPiosenek.txt"))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                String[] dane = linia.split("/");
                if (dane.length == 4) {
                    String tytul = dane[0].trim();
                    String artysta = dane[1].trim();
                    int ocena = Integer.parseInt(dane[2].trim());
                    int bpm = Integer.parseInt(dane[3].trim());

                    listaZPliku.add(new Piosenka(tytul, artysta, ocena, bpm));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Błąd podczas wczytywania pliku: " + e.getMessage());
        }

        Set<Piosenka> zbiorPosortowany = new TreeSet<>();
        zbiorPosortowany.addAll(listaZPliku);

        System.out.println("Zbiór piosenek posortowany po artyście (bez duplikatów):");
        for (Piosenka p : zbiorPosortowany) {
            System.out.println(p);
        }
    }
}
