package com.minghua.mediator.v2;

import java.util.Random;

public class Sale extends AbstractColleague {

    public Sale(AbstractMediator _abstractMediator) {
        super(_abstractMediator);
    }

    public void offSale() {
        super.mediator.execute("sale.offsell");
    }

    public int getSaleStatus() {
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        System.out.println("IBM电脑的销售情况为： " + saleStatus);
        return saleStatus;
    }

    //销售IBM型号的电脑
    public void sellIBMComputer(int number) {
        super.mediator.execute("sale.sell", number);
        System.out.println("销售IBM电脑" + number + "台");
    }
}
