package minghua.common.imporvejava.test;

/**
 * @author: minghua
 * @date: 2018/7/4 21:44
 * @modified By:
 */
public class AliPay extends AbstractPay {
    @Override
    public void perPay() {
        System.out.println("支付宝支付前。。。。。。");
    }

    @Override
    public void afterPay() {
        System.out.println("支付宝支付后。。。。。。");
    }
}
