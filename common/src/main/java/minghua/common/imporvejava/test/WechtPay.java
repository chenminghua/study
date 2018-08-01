package minghua.common.imporvejava.test;

/**
 * @author: minghua
 * @date: 2018/7/4 21:45
 * @modified By:
 */
public class WechtPay extends AbstractPay {
    @Override
    public void perPay() {
        System.out.println("微信支付前。。。。。。");
    }

    @Override
    public void afterPay() {
        System.out.println("微信支付后。。。。。。");
    }
}
