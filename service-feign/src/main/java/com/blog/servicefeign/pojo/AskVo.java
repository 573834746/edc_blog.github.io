package com.blog.servicefeign.pojo;

import java.io.Serializable;

public class AskVo implements Serializable {

    static final long serialVersionUID = 42L;

    private String rules;
    private Integer answer_num;
    private Integer accept_status;

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Integer getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(Integer answer_num) {
        this.answer_num = answer_num;
    }

    public Integer getAccept_status() {
        return accept_status;
    }

    public void setAccept_status(Integer accept_status) {
        this.accept_status = accept_status;
    }
}
