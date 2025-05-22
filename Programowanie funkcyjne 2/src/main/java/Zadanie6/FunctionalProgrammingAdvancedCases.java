package Zadanie6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgrammingAdvancedCases {

    public void mapExample() {
        List<String> names = Arrays.asList("Marysia", "Janek", "Bob", "John");
        names.stream().map(String::length).forEach(System.out::println);
    }
    public void limitAndSort(){
        List<String> names = Arrays.asList("Marysia", "Janek", "Bob", "John");

        String collect = names.stream()
                .filter(s->s.length()>2)
                .limit(5)
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        FunctionalProgrammingAdvancedCases app = new FunctionalProgrammingAdvancedCases();
        app.mapExample();
        app.limitAndSort();
    }
}
