public class FractionJW {
    private int licznik;
    private int mianownik;

    // Konstruktor z łańcuchem znaków
    public FractionJW(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Pusty łańcuch");
        }

        try {
            if (str.contains("/")) {
                int indexUkośnika = str.indexOf('/');
                if (indexUkośnika == 0 || indexUkośnika == str.length() - 1) {
                    throw new IllegalArgumentException("Niepoprawny format ułamka zwykłego");
                }
                String licznikStr = str.substring(0, indexUkośnika);
                String mianownikStr = str.substring(indexUkośnika + 1);
                int num = Integer.parseInt(licznikStr.trim());
                int den = Integer.parseInt(mianownikStr.trim());
                if (den == 0) throw new IllegalArgumentException("Mianownik nie może być 0");
                this.licznik = num;
                this.mianownik = den;
                correction();
                reduce();

            } else if (str.contains(".") || str.contains(",")) {
                char separator = str.contains(".") ? '.' : ',';
                int sepIndex = str.indexOf(separator);

                String częśćCałkowita = str.substring(0, sepIndex);
                String częśćUłamkowa = str.substring(sepIndex + 1);

                if (częśćUłamkowa.isEmpty()) {
                    throw new IllegalArgumentException("Niepoprawny format ułamka dziesiętnego");
                }

                int całkowita = Integer.parseInt(częśćCałkowita.trim());
                int ułamkowa = Integer.parseInt(częśćUłamkowa.trim());

                int mianownik = (int) Math.pow(10, częśćUłamkowa.length());
                int licznik = Math.abs(całkowita) * mianownik + ułamkowa;

                if (całkowita < 0) licznik = -licznik;

                this.licznik = licznik;
                this.mianownik = mianownik;
                correction();
                reduce();

            } else {
                int num = Integer.parseInt(str);
                this.licznik = num;
                this.mianownik = 1;
                correction();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Niepoprawny format liczby: " + str);
        }
    }

    // Konstruktor główny z licznikiem i mianownikiem
    public FractionJW(int licznik, int mianownik) {
        if (mianownik == 0) {
            throw new IllegalArgumentException("parametr n=0!");
        }
        this.licznik = licznik;
        this.mianownik = mianownik;
        correction();
        reduce();
    }

    // Konstruktor bezparametrowy
    public FractionJW() {
        this(0, 1);
    }

    // Konstruktor z jednym parametrem
    public FractionJW(int m) {
        this(m, 1);
    }

    // Konstruktor kopiujący
    public FractionJW(FractionJW other) {
        this(other.licznik, other.mianownik);
    }

    public int getLicznik() {
        return licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
        correction();
        reduce();
    }

    public void setMianownik(int mianownik) {
        if (mianownik <= 0) {
            throw new IllegalArgumentException("Mianownik musi być większy od zera!");
        }
        this.mianownik = mianownik;
        correction();
        reduce();
    }

    public void setFrac(int licz, int mian) {
        if (mian == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerem!");
        }
        this.licznik = licz;
        this.mianownik = mian;
        correction();
        reduce();
    }

    // Korekta znaku - mianownik zawsze dodatni
    private void correction() {
        if (mianownik < 0) {
            licznik = -licznik;
            mianownik = -mianownik;
        }
    }

    // Skracanie ułamka bez parametrów
    public void reduce() {
        int reszta = gcd(Math.abs(licznik), mianownik);
        if (reszta > 1) {
            licznik /= reszta;
            mianownik /= reszta;
        }
    }

    // Skracanie ułamka z podanym dzielnikiem
    public void reduce(int reszta) {
        if (reszta <= 0) {
            throw new IllegalArgumentException("Dzielnik musi być dodatni");
        }
        if (licznik % reszta == 0 && mianownik % reszta == 0) {
            licznik /= reszta;
            mianownik /= reszta;
        }
    }

    // Rozszerzanie ułamka
    public void equivalent(int m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Mnożnik musi być dodatni");
        }
        licznik *= m;
        mianownik *= m;
    }

    // największy wspólny dzielnik
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Mnożenie ułamka przez inny ułamek
    public FractionJW mult(FractionJW other) {
        int nowyLicznik = this.licznik * other.licznik;
        int nowyMianownik = this.mianownik * other.mianownik;
        FractionJW result = new FractionJW(nowyLicznik, nowyMianownik);
        result.reduce();
        return result;
    }

    // Mnożenie ułamka przez liczbę całkowitą
    public FractionJW mult(int n) {
        int nowyLicznik = this.licznik * n;
        int nowyMianownik = this.mianownik;
        FractionJW wynik = new FractionJW(nowyLicznik, nowyMianownik);
        wynik.reduce();
        return wynik;
    }

    // Statyczne metody product (iloczyn)

    //Iloczyn dwóch ułamków
    public static FractionJW product(FractionJW f1, FractionJW f2) {
        int nowyLicznik = f1.licznik * f2.licznik;
        int nowyMianownik = f1.mianownik * f2.mianownik;
        FractionJW wynik = new FractionJW(nowyLicznik, nowyMianownik);
        wynik.reduce();
        return wynik;
    }

    //Iloczyn ułamka i liczby całkowitej
    public static FractionJW product(FractionJW f, int n) {
        int nowyLicznik = f.licznik * n;
        int nowyMianownik = f.mianownik;
        FractionJW wynik = new FractionJW(nowyLicznik, nowyMianownik);
        wynik.reduce();
        return wynik;
    }

    //Iloczyn liczby całkowitej i ułamka
    public static FractionJW product(int n, FractionJW f) {
        return product(f, n); // wykorzystujemy powyższą metodę
    }

    //Iloczyn dwóch liczb całkowitych jako ułamków
    public static FractionJW product(int a, int b) {
        return new FractionJW(a * b, 1);
    }

    // Wartości dziesiętne
    public double doubleValue() {
        return (double) licznik / mianownik;
    }

    public float floatValue() {
        return (float) licznik / mianownik;
    }

    public static double toDouble(FractionJW f) {
        return (double) f.licznik / f.mianownik;
    }

    public static float toFloat(FractionJW f) {
        return (float) f.licznik / f.mianownik;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;               // ten sam obiekt
        if (obj == null) return false;               // null nie jest równy
        if (getClass() != obj.getClass()) return false;  // inna klasa

        FractionJW other = (FractionJW) obj;

        // Tworzymy kopie i redukujemy oba ułamki, żeby porównać ich wartości nieskracalne
        FractionJW f1 = new FractionJW(this.licznik, this.mianownik);
        FractionJW f2 = new FractionJW(other.licznik, other.mianownik);

        f1.reduce();
        f2.reduce();

        return f1.licznik == f2.licznik && f1.mianownik == f2.mianownik;
    }

    @Override
    public int hashCode() {
        FractionJW f = new FractionJW(this.licznik, this.mianownik);
        f.reduce();
        int wynik = 17;
        wynik = 31 * wynik + f.licznik;
        wynik = 31 * wynik + f.mianownik;
        return wynik;
    }

    @Override
    public String toString() {
        return licznik + "/" + mianownik;
    }
}
