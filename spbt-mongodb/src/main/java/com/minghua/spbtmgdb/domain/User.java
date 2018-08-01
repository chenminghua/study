package com.minghua.spbtmgdb.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: minghua
 * @date: 2018/6/28 18:25
 * @modified By:
 */
@Data
@Document(collection = "user")
public class User {
    private String id;
    private String name;
    private String email;
}
