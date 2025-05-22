package Zadanie5;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import org.junit.jupiter.api.Test;

public class FunctionalProgrammingAttend {

   // @Test
    public void lambdaExample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Integer[] integer ={2};
        numbers.stream().map(number -> number*integer[0]).forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(numbers );
        System.out.println("-------------");
        List<Integer> collect=numbers.stream().map(number -> number*integer[0]).collect(Collectors.toList());
        System.out.println(collect );
        System.out.println(numbers );
        /*Stream<Integer> stream = numbers.stream().map(number -> number * integer[0]);
        //integer=22;
        integer[0] = 22;
        stream.forEach(System.out::println);*/
    }

    public static void main(String[] args) {
        FunctionalProgrammingAttend fp = new FunctionalProgrammingAttend();
        fp.lambdaExample();
    }

}
