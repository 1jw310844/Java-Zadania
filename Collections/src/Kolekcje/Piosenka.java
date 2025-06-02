package Kolekcje;

import java.util.Objects;

public class Piosenka implements Comparable<Piosenka> {
    private String tytul;
    private String artysta;
    private int ocena;
    private int bpm;

    public Piosenka(String tytul, String artysta, int ocena, int bpm) {
        this.tytul = tytul;
        this.artysta = artysta;
        this.ocena = ocena;
        this.bpm = bpm;
    }

    public String getTytul() { return tytul; }
    public String getArtysta() { return artysta; }
    public int getOcena() { return ocena; }
    public int getBpm() { return bpm; }

    @Override
    public String toString() {
        return "Tytuł: " + tytul + " | Artysta: " + artysta + " | Ocena: " + ocena + " | BPM: " + bpm;
    }

    @Override
    public int compareTo(Piosenka inna) {
        int porownanie = this.artysta.compareToIgnoreCase(inna.artysta);
        if (porownanie != 0) return porownanie;
        return this.tytul.compareToIgnoreCase(inna.tytul);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piosenka)) return false;
        Piosenka p = (Piosenka) o;
        return tytul.equalsIgnoreCase(p.tytul) &&
                artysta.equalsIgnoreCase(p.artysta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul.toLowerCase(), artysta.toLowerCase());
    }
}
