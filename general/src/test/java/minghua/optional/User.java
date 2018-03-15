package minghua.optional;

import lombok.Getter;

import java.util.Optional;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-7-28
 */
@Getter
public class User {
    private int uid;
    private String name;
    private String password;


    /*
    This has NullPointerException !!!!
     */
//    public static String getName(User user) {
//        return user.getName();
//    }

    public static String getNameSafe(User user){
        if (null == user){
            return null;
        } else {
            return user.getName();
        }
    }

    public static String getNameOptional(User user){
        Optional<String> userName = Optional.ofNullable(user).map(User::getName);
        return userName.orElse(null);
    }
}
