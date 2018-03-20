package com.minghua.chainOfResponsibility.v2;

import com.minghua.chainOfResponsibility.v1.Status;
import com.minghua.chainOfResponsibility.v1.Woman;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClient {
    private List<Woman> womanList = new ArrayList();
    AbstractHandler father = new Father();
    AbstractHandler husband = new Husband();
    AbstractHandler son = new Son();
    @Before
    public void prepareData(){
        father.setNext(husband);
        husband.setNext(son);
        Woman w1 = new Woman(Status.MARRIED, "我想逛街去");
        Woman w2 = new Woman(Status.SINGLE, "我想去逛街");
        Woman w3 = new Woman(Status.WIDOWED, "我想去逛街");
        womanList.add(w1);
        womanList.add(w2);
        womanList.add(w3);
    }
    @Test
    public void v2(){
        for (Woman woman : womanList) {
            father.handleWomanMessage(woman);
        }

    }
}
