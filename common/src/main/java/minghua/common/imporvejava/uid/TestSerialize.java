package minghua.common.imporvejava.uid;

import org.junit.Test;

public class TestSerialize {
    /*
    代码说明：
    1、首先，我们没有对user显示申明serialVersionUID，此时，我们进行序列化、反序列话，没问题
    2、修改user类，增加sex属性，反序列化读取，invalidClass异常

    3、显示声明sserialVersionUID，重复1
    4、重复2步骤，读取正常
     */
    @Test
    public void testSerialize(){
        //User user = new User("黑娃", 48);
        User user = new User("黑娃", 48, "男");
        //将对象保存到本地磁盘
        SerializationUtils.writeObject(user);
    }

    @Test
    public void testDeserialize(){
        //反序列化
        User userFromDisk = (User) SerializationUtils.readObject();
        System.out.println(userFromDisk.toString());
    }
}
