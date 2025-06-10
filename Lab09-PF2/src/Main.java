import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] strings = { "Ala", "ma", "Małego", "białego", "kotka", null };

        Arrays.sort(strings, (x, y) -> {
            if (x == null) return 1;
            if (y == null) return -1;
            return x.compareToIgnoreCase(y);
        });
        System.out.println("Sortowanie z lambda:");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();

        List<String> list = new ArrayList<>(Arrays.asList(strings));
        list.removeIf(Objects::isNull);

        String[] nonNullStrings = list.toArray(new String[0]);
        Arrays.sort(nonNullStrings, String::compareToIgnoreCase);

        System.out.println("Sortowanie z referencją do metody:");
        for (String s : nonNullStrings) {
            System.out.print(s + " ");
        }
        System.out.println();

        List<String> list2 = new ArrayList<>(Arrays.asList("Ala", null, "ma", "", "kotka", null, ""));
        System.out.println("Lista przed usunięciem null i pustych elementów:");
        list2.forEach(System.out::println);

        list2.removeIf(x -> x == null || x.isEmpty());
        System.out.println("Po usunięciu za pomocą lambdy:");
        list2.forEach(System.out::println);


        list2.add(null);
        list2.add("");

        list2.removeIf(Main::isNullOrEmpty);
        System.out.println("Po usunięciu za pomocą referencji do metody:");
        list2.forEach(System.out::println);

        String[] arrayToPrint = { "Ala", "ma", "kota" };
        System.out.println("Wyświetlanie z lambdą:");
        Arrays.stream(arrayToPrint).forEach(x -> System.out.println(x));

        System.out.println("Wyświetlanie z referencją do metody:");
        Arrays.stream(arrayToPrint).forEach(System.out::println);
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
