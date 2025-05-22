package Zadanie2;

//import org.junit.jupiter.api.Test;

public class FunctionalProgrammingThread {

    public void classicThread()throws Exception{

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        t1.start();
    }

    public void functionalThread()throws Exception{

        Thread t1 = new Thread(()->{
            System.out.println("CZEŚĆ");
            System.out.println("CZEŚĆ");
        });
        t1.start();
        Thread t2 = new Thread(()-> System.out.println("WITAM"));
        t2.start();
    }

    public static void main(String[] args) throws Exception{
        FunctionalProgrammingThread ftp = new FunctionalProgrammingThread();
        ftp.functionalThread();
        ftp.classicThread();
    }
}
