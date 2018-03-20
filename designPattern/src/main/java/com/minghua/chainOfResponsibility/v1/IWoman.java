package com.minghua.chainOfResponsibility.v1;

public interface IWoman {
    /**
     *获取妇女类型
     */
    Status getType();

    /**
     * 获取请求
     * @return
     */
    String getRequest();

}
