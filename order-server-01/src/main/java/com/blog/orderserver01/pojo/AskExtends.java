package com.blog.orderserver01.pojo;

import java.io.Serializable;

public class AskExtends implements Serializable {

    static final long serialVersionUID = 42L;

    private Integer aid;
    private String title;
    private String date;
    private String content;
    private Integer collect_num;
    private Integer browse_num;
    private Integer same_num;
    private Integer answer_num;
    private Integer accept_status;
    private String asktids;
    private String ask_types;
    private String[] ask_typesArray;
    private Integer amid;
    private Integer uid;
    private Integer ask_money;
    private String username;
    private String home_url;
    private String photo_url;
    private Integer[] asktidArray;

    public String[] getAsk_typesArray() {
        return ask_typesArray;
    }

    public void setAsk_typesArray(String[] ask_typesArray) {
        this.ask_typesArray = ask_typesArray;
    }

    public Integer[] getAsktidArray() {
        return asktidArray;
    }

    public void setAsktidArray(Integer[] asktidArray) {
        this.asktidArray = asktidArray;
    }

    public Integer getAsk_money() {
        return ask_money;
    }

    public void setAsk_money(Integer ask_money) {
        this.ask_money = ask_money;
    }

    public String getHome_url() {
        return home_url;
    }

    public void setHome_url(String home_url) {
        this.home_url = home_url;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(Integer collect_num) {
        this.collect_num = collect_num;
    }

    public Integer getBrowse_num() {
        return browse_num;
    }

    public void setBrowse_num(Integer browse_num) {
        this.browse_num = browse_num;
    }

    public Integer getSame_num() {
        return same_num;
    }

    public void setSame_num(Integer same_num) {
        this.same_num = same_num;
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

    public String getAsktids() {
        return asktids;
    }

    public void setAsktids(String asktids) {
        this.asktids = asktids;
    }

    public String getAsk_types() {
        return ask_types;
    }

    public void setAsk_types(String ask_types) {
        this.ask_types = ask_types;
    }

    public Integer getAmid() {
        return amid;
    }

    public void setAmid(Integer amid) {
        this.amid = amid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
