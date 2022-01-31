package by.zakharenko.demothreads.test;

public class ClassB extends ClassA{
    public ClassB(){
        System.out.println("ClassB");
    }

    @Override
    public void print(){
        System.out.println("PrintB");
    }
}
