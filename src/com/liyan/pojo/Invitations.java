package com.liyan.pojo;

import java.util.Date;

/**
 * @Author: liyan
 */
public class Invitations {

    private int id;

    private String title;

    private String content;

    private Date postingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Date postingTime) {
        this.postingTime = postingTime;
    }
}
