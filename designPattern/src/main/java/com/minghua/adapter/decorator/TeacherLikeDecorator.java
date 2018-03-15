package com.minghua.adapter.decorator;

import com.minghua.adapter.report.SchooleReport;

public class TeacherLikeDecorator extends Decorator {
    public TeacherLikeDecorator (SchooleReport sr) {
        super(sr);
    }

    private void sayYes() {
        System.out.println("老师说我表现不错！");
    }

    @Override
    public void report() {
        super.report();
        sayYes();
    }
}
