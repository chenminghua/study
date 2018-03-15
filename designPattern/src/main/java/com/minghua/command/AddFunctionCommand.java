package com.minghua.command;

public class AddFunctionCommand extends Command {
    @Override
    public void execute() {
        super.storyGroup.add();
        super.pageGroup.add();
        super.codeGroup.add();
    }
}
