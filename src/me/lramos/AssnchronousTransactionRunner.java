package me.lramos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;

public class AssnchronousTransactionRunner {

    private LinkedBlockingDeque<RunnableTransaction> supplierDeque = new LinkedBlockingDeque<>();

    private Boolean on;

    public AssnchronousTransactionRunner () {
        on = true;
    }

    public void turnOff() {

        RunnableTransaction poisonPill = new RunnableTransaction();
        poisonPill.setPoisonPill(true);

        supplierDeque.offerFirst(poisonPill);
    }

    public void turnOn() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void add(RunnableTransaction runnable) {
        System.out.println("Adicionando runnable");
        supplierDeque.offerLast(runnable);
    }

    private void runner () throws InterruptedException {

        System.out.println("Inicando pooling");

        while (on) {

            System.out.println("Entrou no whilão");

            RunnableTransaction runnable = supplierDeque.take();

            if (runnable.getPoisonPill()) {
                on = false;
                continue;
            }

            Thread thread = new Thread(runnable.getRunnable());

            thread.start();
            thread.join();
            thread.interrupt();

        }

        System.out.println("Runner parado!");

    }

}
