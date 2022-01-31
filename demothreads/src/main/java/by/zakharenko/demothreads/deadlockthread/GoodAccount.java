package by.zakharenko.demothreads.deadlockthread;

public class GoodAccount {
    private final int id;
    private int amount;

    public GoodAccount(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public int getAmount() {
        return this.amount;
    }

    public void transfer(GoodAccount fromAccount, int transferSum) {
        GoodAccount firstBlock;
        GoodAccount secondBlock;
        if (this.id < fromAccount.id) {
            firstBlock = this;
            secondBlock = fromAccount;
        } else {
            firstBlock = fromAccount;
            secondBlock = this;
        }

        synchronized (firstBlock) {
            synchronized (secondBlock) {
                fromAccount.amount -= transferSum;
                this.amount += transferSum;
            }
        }

    }
}
