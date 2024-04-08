package com.juhao666.design.pattern.command;

public class BakeChickenCommand extends Command {
    public BakeChickenCommand(Barbecuer boy) {
        super(boy);
    }

    @Override
    public void executeCommand() {
        executor.bakeChicken();
    }
}
