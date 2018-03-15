package com.minghua.springboot.jpa.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-30
 */
@Entity
@Table(name = "departement")
@Data
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String name;
}
