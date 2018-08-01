package minghua.common.imporvejava.test;

/**
 * @author: minghua
 * @date: 2018/7/4 21:42
 * @modified By:
 */
public abstract class AbstractPay implements IPay{
    @Override
    public void pay() {
        System.out.println("pay.....");
        perPay();
        afterPay();
    }

}
