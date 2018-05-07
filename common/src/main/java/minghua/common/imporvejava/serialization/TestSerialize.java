package minghua.common.imporvejava.serialization;

import minghua.common.imporvejava.uid.SerializationUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 1、我们使用默认的序列化方法，不能满足需求，员工的工资以及绩效将都会被传到计税系统
 * 2、重写readObject以及writeObject，控制序列化以及反序列化过程
 */
public class TestSerialize {
    @Before
    public void serialize() {
        Salary salary = new Salary(1000, 6000);
        Person person = new Person("张三", salary);
        SerializationUtils.writeObject(person);
    }
    @Test
    public void deSerialize(){
        Person person = (Person) SerializationUtils.readObject();
        System.out.println(person.getName());
        System.out.println(person.getSalary().getBasePay());
        System.out.println(person.getSalary().getBonus());
    }
}
