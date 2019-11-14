package me.lramos;

public class RunnableTransaction {

    private Runnable runnable;

    private Boolean isPoisonPill;

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public Boolean getPoisonPill() {
        return isPoisonPill;
    }

    public void setPoisonPill(Boolean poisonPill) {
        isPoisonPill = poisonPill;
    }
}
