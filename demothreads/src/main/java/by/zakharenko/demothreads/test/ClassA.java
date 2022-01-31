package by.zakharenko.demothreads.test;

import java.util.Comparator;
import java.util.concurrent.Callable;


public class ClassA  {



    public ClassA(){
        System.out.println("ClassA");
    }

    public static void staticPrint(){
        System.out.println("StaticPrint");
    }

    public void print(){
        System.out.println("PrintA");
    }
    {
        System.out.println("EEE");
    }
}
