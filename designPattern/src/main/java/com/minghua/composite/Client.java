package com.minghua.composite;

import org.junit.Test;

import java.util.List;

//调用
public class Client {

    @Test
    public void called() {
        //先把一个组织组装起来
        Branch ceo = compositeCorpTree();
        //获取ceo的信息
        System.out.println(ceo.getInfo());
        //获取员工信息
        System.out.println(getTreeInfo(ceo));
    }

    private String getTreeInfo(Branch crop) {
        List<Crop> subordinates = crop.getSubordinate();
        String info = "";
        for (Crop crop1 : subordinates) {
            if (crop1 instanceof Leaf) {
                info = info + crop1.getInfo() + "\n";
            } else {
                info = info + crop1.getInfo() + "\n" + getTreeInfo((Branch) crop1);
            }
        }
        return info;
    }

    private Branch compositeCorpTree() {
        Branch ceo = new Branch("王总", "总经理", 100000);
        //把三个部门经理产生出来
        Branch developDep = new Branch("刘大瘸子", "研发部门经理", 10000);
        Branch salesDep = new Branch("马二拐子", "销售部门经理", 20000);
        Branch financeDep = new Branch("赵三驼子", "财务部经理", 30000);
        //再把三个小组长产生出来
        Branch firstDevGroup = new Branch("杨三乜斜", "开发一组组长", 5000);
        Branch secondDevGroup = new Branch("吴大棒槌", "开发二组组长", 6000);
        //把所有的小兵都产生出来
        Leaf a = new Leaf("a", "开发人员", 2000);
        Leaf b = new Leaf("b", "开发人员", 2000);
        Leaf c = new Leaf("c", "开发人员", 2000);
        Leaf d = new Leaf("d", "开发人员", 2000);
        Leaf e = new Leaf("e", "开发人员", 2000);
        Leaf f = new Leaf("f", "开发人员", 2000);
        Leaf g = new Leaf("g", "开发人员", 2000);
        Leaf h = new Leaf("h", "销售人员", 5000);
        Leaf i = new Leaf("i", "销售人员", 4000);
        Leaf j = new Leaf("j", "财务人员", 5000);
        Leaf k = new Leaf("k", "CEO秘书", 8000);
        Leaf zhengLaoLiu = new Leaf("郑老六", "研发部副经理", 20000);

        //开始组装
        //CEO下有三个部门经理和一个秘书
        ceo.addSubordinate(developDep);
        ceo.addSubordinate(salesDep);
        ceo.addSubordinate(financeDep);
        ceo.addSubordinate(k);

        //研发部经理
        developDep.addSubordinate(zhengLaoLiu);
        developDep.addSubordinate(firstDevGroup);
        developDep.addSubordinate(secondDevGroup);
        //看看开发两个开发小组下有什么
        firstDevGroup.addSubordinate(a);
        firstDevGroup.addSubordinate(b);
        firstDevGroup.addSubordinate(c);
        secondDevGroup.addSubordinate(d);
        secondDevGroup.addSubordinate(e);
        secondDevGroup.addSubordinate(f);
        //再看销售部下的人员情况
        salesDep.addSubordinate(h);
        salesDep.addSubordinate(i);
        //最后一个财务
        financeDep.addSubordinate(j);
        return ceo;
    }
}
