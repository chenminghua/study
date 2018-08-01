package domain;

import lombok.Data;

/**
 * @author: minghua
 * @date: 2018/7/5 18:05
 * @modified By:
 */
@Data
public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private int age;
}
