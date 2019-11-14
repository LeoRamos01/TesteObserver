package me.lramos;

import java.time.LocalDate;

public class TesteObserver {

    public static void main(String[] args) throws InterruptedException {

        AssnchronousTransactionRunner runner = new AssnchronousTransactionRunner();

        runner.turnOn();

        Subject subject = new Subject();

        new TransacaoNovaObserver(subject, runner);

        for (long i = 0; i < 100; i++) {

            boolean isNew = i % 3 == 0 ? false : true;

            subject.notifyTransacao(new Transacao( i, 1l, 20.0, LocalDate.now()), isNew);
        }

        Thread.sleep(10000l);

        runner.turnOff();

    }

}
