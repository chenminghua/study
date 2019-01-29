package minghua.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author: minghua
 * @date: 2019/1/22 15:02
 * @modified By:
 */
public class CollectionTest {
    @Test
    public void testCollection() {
        Map<String, String> guavaMap = Maps.newHashMap();

        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");
        iMap.forEach((k, v) -> System.out.println("key is:" + k + ", value is:" + v));

        List<String> guavaList = Lists.newArrayList("s1", "s2", "s3");
        guavaList.forEach(s -> System.out.println(s));
    }
}
