package com.minghua.command;

public class Client {
    public static void main(String[] args) {
        Invoker leader = new Invoker();
        Command addFuncCommand = new AddFunctionCommand();
        leader.setCommand(addFuncCommand);
        leader.action();
    }
}
