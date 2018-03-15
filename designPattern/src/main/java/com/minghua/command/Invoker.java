package com.minghua.command;

public class Invoker {
    private Command command;


    public void action(){
        this.command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
