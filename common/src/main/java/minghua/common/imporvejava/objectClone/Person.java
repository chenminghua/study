package minghua.common.imporvejava.objectClone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/*
可以用实现Cloneable来实现克隆
但是在clone时，是浅拷贝
假设这样实现，那么在测试用例中，将会导致拷贝对象与原始对象的Father为同一引用，导致小儿子的干爹对大儿子同样适用，坑
那么，Object类提供的默认的clone的处理规则是什么呢？
对与基本类型，拷贝其值
对于引用类型，拷贝其引用（所以测试用例中发生的原因就显而易见了，大儿子的father跟小儿子的father为同一引用）
对于String类型，拷贝其引用，但是在发生修改时，又会去产生一个新的
在使用中，我们应该尽量避免浅拷贝
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person implements Serializable {
    private String name;
    private Person father;

    public Person(String name) {
        this.name = name;
    }
}
