package com.minghua.chainOfResponsibility.v1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPattern {
    private List<Woman> womanList = new ArrayList<Woman>();
    IHnadler fater = new Fater();
    IHnadler husband = new Husband();
    IHnadler son = new Son();
    @Before
    public void prepareData(){
        Woman w1 = new Woman(Status.MARRIED, "我想逛街去");
        Woman w2 = new Woman(Status.SINGLE, "我想去逛街");
        Woman w3 = new Woman(Status.WIDOWED, "我想去逛街");
        womanList.add(w1);
        womanList.add(w2);
        womanList.add(w3);
    }
    @Test
    public void v1(){
        for (Woman woman : womanList) {
            switch (woman.getType()){
                case SINGLE:
                    System.out.println("\n--------女儿向父亲请示-------");
                    fater.handleMessage(woman);
                    break;
                case MARRIED:
                    System.out.println("\n--------妻子向丈夫请示-------");
                    husband.handleMessage(woman);
                    break;
                case WIDOWED:
                    System.out.println("\n--------母亲向儿子请示-------");
                    son.handleMessage(woman);
                    break;
                default:
                    System.out.println("未知");
            }
        }

    }
}
