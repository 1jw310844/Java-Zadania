import java.util.Scanner;
 class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj ułamek (np. 2,4115 lub -852.45 lub -5 lub 2/3):");

        String wejście = skaner.next();

        try {
            FractionJW fraction = new FractionJW(wejście);
            System.out.println("Wczytany ułamek to: " + fraction);
            System.out.println("Wartość dziesiętna (double): " + fraction.doubleValue());
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        skaner.close();
    }
}
