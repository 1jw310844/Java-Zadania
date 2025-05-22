package Zadanie3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalProgrammingReferenceMethod {
    public void ConsumerFull(){
        List<String> names = Arrays.asList("Adrian", "Jakub", "Bartłomiej", "Marcin");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    public void ConsumerShort(){
        List<String> names = Arrays.asList("Adrian", "Jakub", "Bartłomiej", "Marcin");
        names.forEach((String name) -> System.out.println(name));
    }
    public void ConsumerShorter(){
        List<String> names = Arrays.asList("Adrian", "Jakub", "Bartłomiej", "Marcin");
        names.forEach((name) -> System.out.println(name));
    }
    public void ConsumerSuperShort(){
        List<String> names = Arrays.asList("Adrian", "Jakub", "Bartłomiej", "Marcin");
        names.forEach(name-> System.out.println(name));
    }
    public void referenceMethod(){
        List<String> names = Arrays.asList("Adrian", "Jakub", "Bartłomiej", "Marcin");
        names.forEach(System.out::println);
    }

    public static void main(String[] args) {
        FunctionalProgrammingReferenceMethod fp = new FunctionalProgrammingReferenceMethod();
        fp.ConsumerFull();
        fp.ConsumerShort();
        fp.ConsumerShorter();
        fp.ConsumerSuperShort();
        fp.referenceMethod();
    }
}
