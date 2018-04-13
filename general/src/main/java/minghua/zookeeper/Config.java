package minghua.zookeeper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userNm;
    private String userPw;

    public Config(String userNm, String userPw) {
        this.userNm = userNm;
        this.userPw = userPw;
    }
}
