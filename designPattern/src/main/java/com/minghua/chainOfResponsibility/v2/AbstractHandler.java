package com.minghua.chainOfResponsibility.v2;

import com.minghua.chainOfResponsibility.v1.IWoman;
import com.minghua.chainOfResponsibility.v1.Status;

public abstract class AbstractHandler {
    //能处理的级别
    private Status status;
    //下一个处理者
    private AbstractHandler nextHandler;

    //每个实现类都要说明自己能处理的级别
    public AbstractHandler(Status _status){
        this.status = _status;
    }

    final public void handleWomanMessage(IWoman woman){
        if (this.status == woman.getType()){
            this.response(woman);
        } else {
            if (nextHandler != null) {
                nextHandler.handleWomanMessage(woman);
            } else {
                System.out.println("-----------没地方请示了，不做处理！---------\n");
            }
        }
    }

    /**
     * 如果你属于你处理的返回，你应该让她找下一个环节的人，比如
     * 女儿出嫁了，还向父亲请示是否可以逛街，那父亲就应该告诉女儿，应该找丈夫请示
     */
    public void setNext(AbstractHandler _handler){
        this.nextHandler = _handler;
    }

    protected abstract void response(IWoman woman);
}
