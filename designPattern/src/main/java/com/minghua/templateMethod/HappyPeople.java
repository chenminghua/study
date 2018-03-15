package com.minghua.templateMethod;

public abstract class HappyPeople {
    protected  abstract void traval();
    protected final void subcribeTicket() {
        System.out.println("订票。。。。");
    }

    protected final void celebrate() {
        System.out.println("在家庆祝。。。");
    }

    /**
     *  父类规定模版，子类不能改变流程
     */
    public final void celebrateSpringFestival() {
        subcribeTicket();
        traval();
        celebrate();
    }
}
