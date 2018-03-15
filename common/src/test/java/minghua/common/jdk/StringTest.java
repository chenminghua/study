package minghua.common.jdk;


import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-13
 */
public class StringTest {
    @Test
    public void testString() {
        String a = "abc";
        String b = "abc";
        String c = "d";

        String aa = new String("aa");
        String bb = new String("aa");

        Assert.assertTrue(a == b);
        Assert.assertTrue(aa.equals(bb));

        StringBuffer sb = new StringBuffer("abc");//true
        Assert.assertTrue(a.contentEquals(sb));//true
        Assert.assertFalse(a.equals(sb));//false

        Assert.assertTrue(a.startsWith("bc", 1));
        Assert.assertTrue(a.startsWith("a"));

    }
}
