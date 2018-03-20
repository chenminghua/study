package com.minghua.chainOfResponsibility.v1;

public class Woman implements IWoman{
    //默认
    private Status status = Status.SINGLE;
    private String request = "";

    public Woman(Status _status, String _request){
        this.status = _status;
        this.request = _request;
    }
    @Override
    public Status getType() {
        return this.status;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
