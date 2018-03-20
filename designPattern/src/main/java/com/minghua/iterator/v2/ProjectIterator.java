package com.minghua.iterator.v2;

import java.util.ArrayList;

public class ProjectIterator implements IProjectIterator {
    //所有的项目都放在这里ArrayList中
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    private int currentItem = 0;

    //构造函数传入projectList
    public ProjectIterator(ArrayList<IProject> projectList){
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        boolean flag = true;
        if (projectList.size() >= currentItem || projectList.get(currentItem) == null) {
            flag = false;
        }
        return flag;
    }

    @Override
    public Object next() {
        return (IProject) projectList.get(this.currentItem++);
    }

    @Override
    public void remove() {

    }
}
