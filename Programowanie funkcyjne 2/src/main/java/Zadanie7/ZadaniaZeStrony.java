package Zadanie7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZadaniaZeStrony {
    private static final List<String> list = Arrays.asList("aab","aab","aac","aac","bbb","ccc");

    public static void main(String[] args) {
        list.stream().filter(e->e.startsWith("a")).map(String::toUpperCase).peek(System.out::println)
                .collect(Collectors.toList());

        List<String> a = list.stream()
                .filter(e->{
                    System.out.println("Stream - filter: " + e);
                    return e.startsWith("a");
                })
                .map(e->{
                    System.out.println("Stream - map: " + e);
                    return e.toUpperCase();
                })
                .collect(Collectors.toList());
        list.parallelStream()
                .filter(e->{
                    System.out.println("Stream - filter: " + e);
                    return e.startsWith("a");
                })
                .map(e->{
                    System.out.println("Stream - map: " + e);
                    return e.toUpperCase();
                })
                .collect(Collectors.toList());
    }
}
