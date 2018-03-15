package minghua.inheritance;

import org.junit.Test;

/*
 * @Description: 
 * @author minghua.chen 
 * @date 17-12-4 18:04
 * @version V1.0
 */
public class HumanTest {
    @Test
    public void test(){
        //这里将分别调用父类的构造函数以及子类的构造函数
        Human h1 = new Black();
        //将是子类的类名
        System.out.println(h1.getClass().getName());
        //kind属性在父类、子类中都存在，这里将调用到父类的属性
        System.out.println(h1.kind);
       // h1.sayHipop();
        //System.out.println(h1.name);

        Black h2 = new Black();
        //这里将调用到子类的属性
        System.out.println(h2.kind);
    }

}
