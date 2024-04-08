package com.juhao666.design.pattern.command;

public class BakeMuttonCommand extends Command{

    public BakeMuttonCommand(Barbecuer executor) {
        super(executor);
    }

    @Override
    public void executeCommand() {
        executor.bakeMutton();
    }
}
