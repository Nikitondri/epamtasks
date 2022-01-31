package by.zakharenko.demothreads.interruptedThread;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();
        try{
            Thread.sleep(31);
            t.interrupt();

            Thread.sleep(31);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
