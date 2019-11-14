package me.lramos;

public abstract class Observer {

    protected Subject subject;

    public abstract void update(Boolean isNew);

}
