package com.blog.servicezuul.pojo;

/**
 * 博客类
 */
public class Blogs {

    private Integer bid;
    private String title;
    private String content;
    private Integer update_num;
    private String published_date;
    private String update_date;
    private Integer private_status;
    private Integer atid;
    private Integer btid;
    private Integer uid;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpdate_num() {
        return update_num;
    }

    public void setUpdate_num(Integer update_num) {
        this.update_num = update_num;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public Integer getPrivate_status() {
        return private_status;
    }

    public void setPrivate_status(Integer private_status) {
        this.private_status = private_status;
    }

    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    public Integer getBtid() {
        return btid;
    }

    public void setBtid(Integer btid) {
        this.btid = btid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

}
