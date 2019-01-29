package minghua.guava;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: minghua
 * @date: 2019/1/22 16:08
 * @modified By:
 */
public class StringTest {
    @Test
    public void testString() {
        //字符串拼接，跳过空字符串
        String str = Joiner.on(",").skipNulls().join("a", "b", "c");
        Assert.assertEquals("a,b,c", str);

        //  /productKey/deviceName/get
        Assert.assertEquals("/productKey/deviceName/get", Joiner.on("/").join("/productKey", "deviceName", "get"));

    }
}
