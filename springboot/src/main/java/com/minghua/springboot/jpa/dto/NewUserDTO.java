package com.minghua.springboot.jpa.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewUserDTO implements Serializable {
    private String name;
    private String email;
    private int dept;
}
