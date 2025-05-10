package Zadanie1;

public class Zadanie1 {
    public static void main(String[] args) {

        for (int i = 48; i <= 124; i++) {
            char znak = (char) i;
            System.out.println("Kod: " + i + " => Znak: " + znak);
        }
        System.out.println();

        System.out.print("Napis: ");
        System.out.print((char)72);
        System.out.print((char)101);
        System.out.print((char)108);
        System.out.print((char)108);
        System.out.print((char)111);
        System.out.print((char)33);
        System.out.println();
    }
}
