public class Main {
    public static void main(String[] args) {
        Osoba[] osoby = new Osoba[9];

        osoby[0] = new TestPracownik();
        osoby[1] = new TestPracownik(3500);
        osoby[2] = new TestPracownik("Wesoły", 4500);

        osoby[3] = new Student();
        osoby[4] = new Student("Informatyka");
        osoby[5] = new Student("Szewczyk", "Matematyka");

        osoby[6] = new Menadzer();
        osoby[7] = new Menadzer(8000);
        osoby[8] = new Menadzer("Pawlik", 10000);

        for (Osoba o : osoby) {
            if (o instanceof Menadzer) {
                ((Menadzer) o).zmienBonus(5000);
            }
        }

        for (Osoba o : osoby) {
            if (o instanceof TestPracownik) {
                ((TestPracownik) o).podniesPensje(5);
            }
        }

        for (Osoba o : osoby) {
            System.out.println(o + ", " + o.getOpis());
        }
    }
}