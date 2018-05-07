package minghua.common.imporvejava.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Salary salary;

    public Person(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }





    /**
     * 序列化委托方法
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(salary.getBasePay());
    }
    /**
     * 反序列化委托方法
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        salary = new Salary(in.readInt(), 0);
    }
}
