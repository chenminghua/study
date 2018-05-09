package com.minghua.springboot.jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-29
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "dept")
    private Departement dept;

    public User(String name, String email, Departement dept) {
        this.name = name;
        this.email = email;
        this.dept = dept;
    }
}
