package minghua.common.imporvejava.override;

public class Sub extends Base {
    @Override
    protected void fun(int price, int[] discount) {
        System.out.println("sub fun()");
    }
}
