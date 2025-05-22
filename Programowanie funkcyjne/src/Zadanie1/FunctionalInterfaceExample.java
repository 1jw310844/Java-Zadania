package Zadanie1;

import javax.xml.transform.Source;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Function<Integer,String> functin = t->t+t+"zajecia.pl";
        System.out.println(functin.apply(69));
        Predicate<Student> predykat = p->p.getAge()>21;
        boolean test1 = predykat.test(new Student("Adrian","Szewczyk",21));
        boolean test2 = predykat.test(new Student("Jakub","Wesoły",22));
        System.out.println(test1);
        System.out.println(test2);

    }
}
