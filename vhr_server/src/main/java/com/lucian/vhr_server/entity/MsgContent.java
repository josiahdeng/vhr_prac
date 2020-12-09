package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (MsgContent)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:30
 */
public class MsgContent implements Serializable {
    private static final long serialVersionUID = 357896810842351058L;

    private Integer id;

    private String title;

    private String message;

    private Date createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}