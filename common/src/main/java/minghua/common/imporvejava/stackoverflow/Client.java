package minghua.common.imporvejava.stackoverflow;

import org.junit.Test;

public class Client {
    /**
     * 以下将会产生一个stackoverflow的异常！！！！！！
     * 声明s变量时，将会调用son的无参构造函数
     * jvm又默认调用father的无参构造函数
     * 此时，Fatehr类又初始化了Other类，other类调用了son类
     * 于是，出现了死循环。
     */
    @Test
    public void test() {
        Son s = new Son();
        s.doSomething();
    }

}
