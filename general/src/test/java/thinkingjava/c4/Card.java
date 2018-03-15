package thinkingjava.c4;

/*
 * @Description: 
 * @author minghua.chen 
 * @date 17-12-6 23:12
 * @version V1.0
 */
public class Card {
    static Tag t55;
    Tag t66;
    Card() {
        System.out.println("Card()");
        t3 = new Tag(3);
    }
    Tag t3 = new Tag(33);

    static Tag t4 = new Tag(4);

    static {
        t55 = new Tag(55);
    }
    {
        t66 = new Tag(66);
    }
}
