package minghua.common.imporvejava.ternary;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

public class Ternary {
    @Test
    public void teranryTest(){
        int i = 80;
        String s1 = String.valueOf(i < 90 ? 90 : 100);
        String s2 = String.valueOf(i < 90 ? 90 : 100.0);

        /*
        此时，返回的类型是不一样的，s2的语句返回了精度更高的类型
         */
        assertNotEquals(s1, s2);
    }
}
