package com.minghua.adapter;

import com.minghua.adapter.decorator.HighScoreDecorator;
import com.minghua.adapter.decorator.SortDecorator;
import com.minghua.adapter.decorator.TeacherLikeDecorator;
import com.minghua.adapter.report.FouthGradeReport;
import com.minghua.adapter.report.SchooleReport;

public class Father {
    public static void main(String[] args) {
        //first time
        SchooleReport report = new FouthGradeReport();
        //report.report();
        //考这么差，休想签字
        //report.sign("老王");

        //System.out.println("******************************fail!!!*****************************");

        //second time
        SchooleReport sr;
        sr = new FouthGradeReport();
        sr = new HighScoreDecorator(sr);
        sr = new SortDecorator(sr);
        sr = new TeacherLikeDecorator(sr);
        sr.report();
//        sr = new SortDecorator(sr);
//        sr.report();
        sr.sign("老王");
    }
}
