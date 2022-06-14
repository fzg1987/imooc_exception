package com.fzg.imooc.exam2.entity;

import java.io.Serializable;

/*
 * 用户实体
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6383047422635L;
    private int id;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username;            // 用户名
    private String password;            // 密码

    public User() {
        super();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
