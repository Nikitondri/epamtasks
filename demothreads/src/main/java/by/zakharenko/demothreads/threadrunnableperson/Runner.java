package by.zakharenko.demothreads.threadrunnableperson;

public class Runner {
    public static void main(String[] args) {
        RunnablePerson runnablePerson = new RunnablePerson("Alice");
        Thread t1 = new Thread(runnablePerson);
        t1.start();

        RunnablePerson runnablePerson1 = new RunnablePerson("Bob");
        Thread t2 = new Thread(runnablePerson1);
        t2.start();

    }
}
