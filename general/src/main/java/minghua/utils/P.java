package minghua.utils;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-7-28
 */
public class P {
    public static void rintln (Object ... objs) {
        for (Object obj : objs)
            System.out.println(obj.toString());
    }
}
