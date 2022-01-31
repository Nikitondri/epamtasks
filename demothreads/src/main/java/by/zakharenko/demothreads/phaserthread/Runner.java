package by.zakharenko.demothreads.phaserthread;

import java.util.concurrent.Phaser;

public class Runner {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser, "Washer").start();
        new Washer1(phaser, "Washer1").start();
    }

    public static class Washer extends Thread{
        Phaser phaser;

        public Washer(Phaser phaser, String name) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println(getName() + " Washing body car " + i);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
            }
        }
    }

    public static class Washer1 extends Thread{
        Phaser phaser;

        public Washer1(Phaser phaser, String name) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println(getName() + " Washing salon car " + i);
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
