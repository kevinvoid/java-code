package com.solverpeng.example;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String emailAddress;
}
