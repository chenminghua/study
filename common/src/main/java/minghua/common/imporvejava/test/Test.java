package minghua.common.imporvejava.test;

/**
 * @author: minghua
 * @date: 2018/7/4 21:49
 * @modified By:
 */
public class Test {
    public static void main(String[] args) {
        AbstractPay pay = new AliPay();
        pay.pay();
    }
}
