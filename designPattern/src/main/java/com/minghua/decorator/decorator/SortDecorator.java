package com.minghua.decorator.decorator;

import com.minghua.decorator.report.SchooleReport;

public class SortDecorator extends Decorator {
    public  SortDecorator(SchooleReport sr) {
        super(sr);
    }

    //告诉老爸学校的排名情况
    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        super.report();
        reportSort();
    }
}
