package com.minghua.state;

import org.junit.Test;

public class TestStatePattern {
    @Test
    public void demoCall() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.print(context.getState().toString());
    }
}
