package com.minghua.command;

public abstract class Command {
    protected StoryGroup storyGroup = new StoryGroup();
    protected PageGroup pageGroup = new PageGroup();
    protected CodeGroup codeGroup = new CodeGroup();
    public abstract void execute();
}
