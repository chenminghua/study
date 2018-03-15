package minghua.inheritance;

/*
 * @Description: 
 * @author minghua.chen 
 * @date 17-12-4 18:03
 * @version V1.0
 */
public class Black extends Human {
    public Black(){
        System.out.println("constructor of Black!");
    };

    public void sayHipop() {
        System.out.println("yoyo");
    }

    protected String kind = "黑人";
    protected String name = "aaaaa";
}
