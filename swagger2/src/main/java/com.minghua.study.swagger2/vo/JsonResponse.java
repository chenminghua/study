package com.minghua.study.swagger2.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: minghua
 * @date: 2018/6/7 8:09
 * @modified By:
 */
@Data
@ToString
public class JsonResponse implements Serializable {
    private static final int DEFAULT_CODE = 200;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private int code;
    private String msg;
    private Object data;

    public JsonResponse(){
        super();
        this.code = DEFAULT_CODE;
        this.msg = SUCCESS;
    }

    public JsonResponse(int code, String msg, JSONObject data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonResponse fail(){
        return new JsonResponse(201, "参数错误", null);
    }
}
