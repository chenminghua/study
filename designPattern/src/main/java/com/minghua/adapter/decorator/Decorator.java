package com.minghua.adapter.decorator;

import com.minghua.adapter.report.SchooleReport;

public abstract class Decorator extends SchooleReport {
    //首先知道哪个成绩单
    SchooleReport sr;

    public Decorator (SchooleReport sr) {
        this.sr = sr;
    }

    //成绩单还是要被看到的
    @Override
    public void report(){
        this.sr.report();
    }

    //看完毕还是要签名的
    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }

}
