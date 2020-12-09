package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (SysMsg)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:39
 */
public class SysMsg implements Serializable {
    private static final long serialVersionUID = -47797933736834841L;

    private Integer id;
    /**
     * 消息id
     */
    private Integer mId;
    /**
     * 0表示群发消息
     */
    private Integer type;
    /**
     * 这条消息是给谁的
     */
    private Integer hrId;
    /**
     * 0 未读 1 已读
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}