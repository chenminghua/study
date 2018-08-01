package com.minghua.spbtmgdb.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author: minghua
 * @date: 2018/7/31 19:16
 * @modified By:
 */
@Data
@Document(collection = "freezerStatus")
public class FreezerStatus {
    private String devSn;
    private Date dateTime;
    private String statusTimes;
    //冷餐
    private double lengcang;
    private double lengdong;
    //变温室
    private double bianwen;
    private double lengcangZhengfa;
    private double lengdongZhengfa;
    private double bianwenZhengfa;
    private double outter;
    private double positon;
    private boolean diankong;
    private boolean camara;
    private boolean duandian;
    private boolean wifiOn;

    public FreezerStatus() {
        this.lengcang = 1.0;
        this.lengcang = 10;
        this.bianwen = 5;
        this.lengcangZhengfa = 20;
        this.lengdongZhengfa = 30;
        this.bianwenZhengfa = 15;
        this.outter = 30;
        this.positon = 100;
        this.diankong = false;
        this.camara = true;
        this.duandian = false;
        this.wifiOn = true;
    }
}
