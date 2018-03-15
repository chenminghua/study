package minghua.optional;

import minghua.common.utils.P;
import org.junit.Test;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-7-28
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        User user = null;
//        try {
//            P.rintln(User.getName(user));
//        } catch (Exception e) {
//            P.rintln(e.toString());
//        }

        P.rintln(User.getNameOptional(user));


    }
}
