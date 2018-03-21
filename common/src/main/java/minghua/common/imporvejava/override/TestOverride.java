package minghua.common.imporvejava.override;

import org.junit.Test;

public class TestOverride {
    @Test
    public void testOverride(){
        //向上转型
        Base base = new Sub();
        base.fun(100,50);
        //不转型
        Sub sub = new Sub();

        //编译不过！！！！！
        // sub.fun(100, 50);
    }
}
