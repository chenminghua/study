package minghua.common.imporvejava.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringTest {
    @Test
    public void testString(){
        String s = "   ";
        Assert.assertEquals(3, s.length());

        String s1 = "abc";
        System.out.println(s1.codePointAt(1));

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        Assert.assertTrue(s1.contentEquals(sb1));
        Assert.assertTrue(s1.contentEquals(sb2));

        String s3 = "abcdef";
        Assert.assertEquals(3, s3.compareTo(s1));
    }

    @Test
    public void testIntegerEquals(){
        Integer i1 = 127;
        Integer i2 = 127;
        //从cache中获取，所以== 为true
        assertTrue(i1 == i2);

        //两个对象，所以== 为false
        Integer i3 = 128;
        Integer i4 = 128;
        assertFalse(i3 == i4);
    }
}
