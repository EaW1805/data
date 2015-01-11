package com.eaw1805.data.model;

import java.io.Serializable;
import java.util.Date;


public class PostMessage implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int postMessageId;

    private int userId;

    private Date date;

    private String content;


    public int getPostMessageId() {
        return postMessageId;
    }

    public void setPostMessageId(int postMessageId) {
        this.postMessageId = postMessageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
