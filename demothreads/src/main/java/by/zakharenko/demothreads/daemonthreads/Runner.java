package by.zakharenko.demothreads.daemonthreads;

public class Runner {
    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        SimpleThread daemon = new SimpleThread();
        daemon.setDaemon(true);
        daemon.start();
        thread.start();
        System.out.println("Конец потока main");
    }
}
