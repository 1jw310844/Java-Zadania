public class Main {
    public static void main(String[] args) {
        // Test Kontener01
        Kontener01 k1 = new Kontener01(3);
        k1.set(0, 10);
        k1.set(2, 20);
        k1.set(5, 99); // wymusi resize
        System.out.println("Kontener01:");
        for (int i = 0; i < k1.size(); i++) {
            System.out.print(k1.get(i) + " ");
        }

        // Test Kontener02
        Kontener02 k2 = new Kontener02(2);
        k2.set(0, "Hello");
        k2.set(1, 123);
        k2.set(3, 45.67); // wymusi resize
        System.out.println("\n\nKontener02:");
        System.out.println(k2);

        // Test Kontener03
        Kontener03 k3 = new Kontener03(2);
        k3.set(0, "Java");
        k3.set(1, true);
        k3.set(2, 3.14);
        System.out.println("\nKontener03 (Iterable):");
        for (Object obj : k3) {
            System.out.println(obj);
        }
    }
}
