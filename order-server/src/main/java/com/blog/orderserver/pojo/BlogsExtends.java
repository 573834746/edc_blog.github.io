package com.blog.orderserver.pojo;

/**
 * 博客扩展类
 * 一般使用这个：）
 */
public class BlogsExtends {

    private String name;
    private String username;
    private String home_url;
    private String photo_url;

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
    private Integer data_id;
    private String blog_url;
    private Integer read_num;
    private Integer comment_num;
    private String blog_type;

    public String getBlog_type() {
        return blog_type;
    }

    public void setBlog_type(String blog_type) {
        this.blog_type = blog_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getData_id() {
        return data_id;
    }

    public void setData_id(Integer data_id) {
        this.data_id = data_id;
    }

    public String getBlog_url() {
        return blog_url;
    }

    public void setBlog_url(String blog_url) {
        this.blog_url = blog_url;
    }

    public Integer getRead_num() {
        return read_num;
    }

    public void setRead_num(Integer read_num) {
        this.read_num = read_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_url() {
        return home_url;
    }

    public void setHome_url(String home_url) {
        this.home_url = home_url;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

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
}
