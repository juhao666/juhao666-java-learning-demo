package com.juhao666.design.pattern.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Waiter {
    private ArrayList<Command> commands = new ArrayList<Command>();

    public void setOrder(Command command){
        System.out.println("add new command "+ command.getClass().getSimpleName()+" at " + getNowTime());
        commands.add(command);
    }

    public void cancelOrder(Command command){
        System.out.println("del the command "+ command.getClass().getSimpleName()+" at " + getNowTime());
        commands.remove(command);
    }

    public void notifyCommand(){
        for(Command c : commands){
            c.executeCommand();
        }
    }

    private String getNowTime(){
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        return formater.format(new Date());
    }
}
