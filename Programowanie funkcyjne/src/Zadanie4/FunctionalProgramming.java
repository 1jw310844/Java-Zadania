package Zadanie4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalProgramming {

   // @Test
    public void classicProgrammingExample(){
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob","Tadeusz","Bożydar");
        long counter =0;
        for(String name : names){
            if(name.length()>6){
                counter++;
            }
        }
        System.out.println(counter);
    }

    //@Test
    public void functionalProgrammingExample(){
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob","Tadeusz","Bożydar");
        long counter = names.stream().filter(name -> name.length()>6).count();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        FunctionalProgramming fp = new FunctionalProgramming();
        fp.classicProgrammingExample();
        fp.functionalProgrammingExample();
    }
}
