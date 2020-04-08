package com.fss.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;

    public static void main(String[] args) {
        new User().getAge();
    }
}
