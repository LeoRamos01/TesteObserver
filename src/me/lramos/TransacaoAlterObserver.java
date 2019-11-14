package me.lramos;

public class TransacaoAlterObserver extends Observer {

    public TransacaoAlterObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(Boolean isNew) {

        if (isNew) {
            System.out.println("Não é problema do alter!");
        } else {
            System.out.println("Alterado: " + subject.getLast());
        }
    }

}