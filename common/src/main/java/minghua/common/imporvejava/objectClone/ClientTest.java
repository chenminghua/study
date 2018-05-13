package minghua.common.imporvejava.objectClone;

import org.junit.Test;

public class ClientTest {
    @Test
    public void testClone(){
        //父亲
        Person father = new Person("Jack");
        //大儿子
        Person bigSon = new Person("Jim", father);
        //通过大儿子拷贝一个小儿子
        Person littleSon = CloneUtil.clone(bigSon);
        littleSon.setName("Jin");

        //小儿子认干爹
        littleSon.getFather().setName("干爹");


        System.out.println("大儿子的父亲是：" + bigSon.getFather().getName());
        System.out.println("小儿子的父亲是：" + littleSon.getFather().getName());
    }
}
