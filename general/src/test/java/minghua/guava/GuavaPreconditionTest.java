package minghua.guava;

import org.apache.commons.lang3.Validate;
import org.junit.Test;

/**
 * @author: minghua
 * @date: 2018/9/25 14:27
 * @modified By:
 */
public class GuavaPreconditionTest {

    @Test
    public void testGuavaPrecondition(){
        int length = 1;
        Validate.isTrue(length > 2, "length is %d, less than 2", length);
    }
}
