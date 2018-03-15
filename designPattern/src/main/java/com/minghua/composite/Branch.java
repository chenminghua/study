package com.minghua.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Crop {
    private List<Crop> subordinateList = new ArrayList<Crop>();

    public Branch(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }

    //增加一个下属，有可能是小头目，也有可能是小兵
    public void addSubordinate(Crop crop){
        this.subordinateList.add(crop);
    }

    //看看有哪些小兵
    public List<Crop> getSubordinate() {
        return this.subordinateList;
    }
    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
