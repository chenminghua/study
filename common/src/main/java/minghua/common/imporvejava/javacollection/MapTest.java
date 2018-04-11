package minghua.common.imporvejava.javacollection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    private static Map map = null;
    static {
        map = new HashMap();
        map.put("key1","lisi1");
        map.put("key2","lisi2");
        map.put("key3","lisi3");
        map.put("key4","lisi4");
        map.put("key5","lisi5");
        map.put("key6","lisi6");
        map.put("key7","lisi7");
        map.put("key8","lisi8");
    }
    @Test
    public void testMap(){
        //遍历1
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if ("key1".equals(key)) {
                //将会报错，提示“java.util.ConcurrentModificationException”
                //map.remove(key);
                //正常删除
                iterator.remove();
            } else {
                System.out.println(key + "->" + map.get(key));
            }
        }

        //遍历2
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            String key = (String) entry.getKey();
            if ("key2".equals(key)) {
                //将会报错，提示“java.util.ConcurrentModificationException”
               // map.remove(key);
                //正常删除
                iterator1.remove();
            } else {
                System.out.println(key + "-->" + entry.getValue());
            }

        }
        //同1

        //遍历3
        map.forEach((key, value) -> {
            System.out.println(key + "--->" + value);
        });


    }
}
