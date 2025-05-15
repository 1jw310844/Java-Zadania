import java.util.Random;

abstract class Osoba {
    private static int nastepnyId;
    private final int id;
    private String nazwisko = "Domyślne";

    static {
        Random rand = new Random();
        nastepnyId = rand.nextInt(100);
        System.out.println("Statyczny blok inicjalizacji Osoba: nastepnyId = " + nastepnyId);
    }

    {
        id = nastepnyId++;
    }

    public Osoba() {}

    public Osoba(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public abstract String getOpis();

    @Override
    public String toString() {
        return getClass().getName() + "{id=" + id + ", nazwisko='" + nazwisko + "'}";
    }
}

class TestPracownik extends Osoba {
    private double pensja;

    public TestPracownik() {
        super();
        this.pensja = 0.0;
    }

    public TestPracownik(double pensja) {
        super();
        this.pensja = pensja;
    }

    public TestPracownik(String nazwisko, double pensja) {
        super(nazwisko);
        this.pensja = pensja;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public void podniesPensje(double procent) {
        this.pensja += this.pensja * procent / 100.0;
    }

    @Override
    public String getOpis() {
        return "Pensja: " + pensja;
    }

    @Override
    public String toString() {
        return super.toString() + ", pensja=" + pensja + "}";
    }
}

class Menadzer extends TestPracownik {
    private double bonus;

    public Menadzer() {
        super();
        this.bonus = 0.0;
    }

    public Menadzer(double pensja) {
        super(pensja);
        this.bonus = 0.0;
    }

    public Menadzer(String nazwisko, double pensja) {
        super(nazwisko, pensja);
        this.bonus = 0.0;
    }

    public void zmienBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getPensja() {
        return super.getPensja() + bonus;
    }

    @Override
    public String getOpis() {
        return "Pensja + bonus: " + getPensja();
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", bonus=" + bonus + "}";
    }
}

class Student extends Osoba {
    private String kierunek;

    public Student() {
        super();
        this.kierunek = "Nieznany";
    }

    public Student(String kierunek) {
        super();
        this.kierunek = kierunek;
    }

    public Student(String nazwisko, String kierunek) {
        super(nazwisko);
        this.kierunek = kierunek;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    @Override
    public String getOpis() {
        return "Kierunek studiów: " + kierunek;
    }

    @Override
    public String toString() {
        return super.toString() + ", kierunek='" + kierunek + "'}";
    }
}