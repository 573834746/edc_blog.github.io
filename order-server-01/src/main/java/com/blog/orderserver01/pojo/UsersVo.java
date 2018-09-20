package com.blog.orderserver01.pojo;

import java.io.Serializable;

public class UsersVo implements Serializable {

    private static final long serialVersionUID = -5725538812909024770L;

    private String username;//用户名
    private String password;//密码
    private String salt;//盐

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
