package minghua.common.imporvejava.uid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 5799L;
    private String name;
    private int age;
    private String sex;
}
