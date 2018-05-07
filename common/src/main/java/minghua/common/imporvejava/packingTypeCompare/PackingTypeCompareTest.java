package minghua.common.imporvejava.packingTypeCompare;

import org.junit.Test;

public class PackingTypeCompareTest {
    @Test
    public void testInteger() {
        Integer integer1 = new Integer(100);
        Integer integer2 = new Integer(100);

        Integer integer13 = new Integer(100);
        Integer integer23 = new Integer(200);

        Integer integer11 = 127;
        Integer integer21 = 127;

        Integer integer12 = 128;
        Integer integer22 = 128;

        System.out.println(integer13 < integer23);

        System.out.println(integer1 == integer2);
        System.out.println(integer11 == integer21);
        System.out.println(integer12 == integer22);
    }

    @Test
    public void autoWraped(){
        int a = 100;
        f(a);

    }

    public void f(long a){
        System.out.println("called long!");
        System.out.println(a);
    }
    public void f(Long a){
        System.out.println("called Long!");
        System.out.println(a);
    }
}
