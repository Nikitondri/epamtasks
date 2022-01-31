package by.zakharenko.demothreads.deadlockthread;

public class BadAccount {
    private final int id;
    private int amount;

    public BadAccount(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public int getAmount() {
        return this.amount;
    }

    public synchronized void transfer(BadAccount fromAccount, int transferSum) {
        synchronized (fromAccount) {
            fromAccount.amount -= transferSum;
            this.amount += transferSum;
        }
    }
}
