package com.blog.servicezuul.pojo;

import java.io.Serializable;

/**
 * 短信验证类
 */
public class SmsStatus implements Serializable {
    private String code;
    private String yz;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz;
    }
}
