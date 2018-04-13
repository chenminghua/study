package minghua.lombook;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
//        User user = new User();
//        user.setName("111");
//        log.info(user.toString());

        User user1 = User.builder().id(2).name("李斯").sex(1).email("2@qq.com").address("秦国").build();

        p(user1.toString());

        p(null);
    }

    private static void p(@NonNull String msg) {
        System.out.println(msg);
    }
}
