package minghua.jdk;


import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

        assertTrue(a == b);
        assertTrue(aa.equals(bb));

        StringBuffer sb = new StringBuffer("abc");//true
        assertTrue(a.contentEquals(sb));//true
        assertFalse(a.equals(sb));//false

        assertTrue(a.startsWith("bc", 1));
        assertTrue(a.startsWith("a"));

    }

    @Test
    public void testNullString(){
        String s = null;
        assertTrue(null == s);
        assertFalse("".equals(s));
        String s1 = paramNotNull("abc");

        assertTrue("null annotation check fail -" , s1.equals("abc@"));
    }
    private String paramNotNull(String s) {
        return s.concat("@");
    }
}
