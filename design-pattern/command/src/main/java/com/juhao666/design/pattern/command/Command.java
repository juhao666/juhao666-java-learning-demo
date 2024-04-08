package com.juhao666.design.pattern.command;

public abstract class Command {
    protected Barbecuer executor;

    public Command(Barbecuer executor){
        this.executor = executor;
    }

    public abstract void executeCommand();

}
