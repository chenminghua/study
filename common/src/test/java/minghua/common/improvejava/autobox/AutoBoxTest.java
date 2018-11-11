package minghua.common.improvejava.autobox;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author: minghua
 * @date: 2018/9/15 15:22
 * @modified By:
 */

public class AutoBoxTest {
    /**
     * 我们常说在比较对象时，尽量使用equals而不是==，一般情况下，我们认为这是因为大于127的会产生新的对象，导致==失效
     * 其实，这个可以在jvm动态调整
     * 参数为: -XX:AutoBoxCacheMax=20000    --推荐参数为20000
     * 在该参数的加持下，如下的测试用例全部通过，所以，知其然，知其所以然
     */
    @Test
    public void testAutoBox() {
        Integer a = 200000;
        Integer b = 200000;
        int c = 200000;

        assertThat("failure - They are equals!", a, equalTo(b));
        assertThat("failure,- They are ==", a == b);
        assertThat("failure,- They are ==", a == c);
    }
}
