package com.minghua.composite;

public abstract class Crop {
    private String name;
    private String position;
    private int salary;

    public Crop(String _name, String _position, int _salary) {
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }

    //获得员工信息
    public String getInfo(){
        String info = "";
        info = "姓名： " + this.name;
        info = info + "\t职位： "+ this.position;
        info = info + "\t薪水： " + this.salary;
        return info;
    }
}
