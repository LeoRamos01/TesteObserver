package me.lramos;

public class TransacaoNovaObserver extends Observer {

    private AssnchronousTransactionRunner runner;

    public TransacaoNovaObserver(Subject subject, AssnchronousTransactionRunner runner) throws InterruptedException {
        this.subject = subject;
        this.subject.attach(this);
        this.runner = runner;
    }

    @Override
    public void update(Boolean isNew) {

        System.out.println("Entrou no update do Observer.");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (isNew) {
                    System.out.println("Nova transação recebida: " + subject.getLast());
                } else {
                    System.out.println("Alteração de transação: " + subject.getLast());
                }
            }
        };

        RunnableTransaction runnableTransaction = new RunnableTransaction();
        runnableTransaction.setRunnable(runnable);
        runnableTransaction.setPoisonPill(false);

        runner.add(runnableTransaction);

    }

}