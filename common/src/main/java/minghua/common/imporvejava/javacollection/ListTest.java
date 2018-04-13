package minghua.common.imporvejava.javacollection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    private List<String> list = null;
    @Before
    public void getMyList(){
        list = new ArrayList(5);
        list.add("value1");
        list.add("value2");
        list.add("value3");
        list.add("value4");
        list.add("value5");
    }

    @Test
    public void deleteEle() {
        //java.util.ConcurrentModificationException
//        for (String s : list) {
//            list.remove(s);
//        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            if ("value1".equals(s)) {
                it.remove();
            } else {
                System.out.println(s);
            }
        }
    }

    @Test
    public void traverse() {
        //for loop
        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("**************************");

        //foreach in java8
        list.forEach(obj -> {
            System.out.println(obj);
        });

        System.out.println("**************************");

        //method reference
        list.forEach(System.out::println);

        System.out.println("**************************");
        //Stream and filter
        //Output : value1
        list.stream()
                .filter(s->s.contains("value1"))
                .forEach(System.out::println);

    }
}
