package com.ddb.demo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author biaoyang
 * @Description:
 * @date 2018/9/21 00219:50
 */
@Entity
@Table
public class People implements Serializable {
    private static final long serialVersionUID = 1999135607336182896L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
