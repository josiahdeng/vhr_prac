package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Oplog)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:34
 */
public class Oplog implements Serializable {
    private static final long serialVersionUID = -25111252538996678L;

    private Integer id;
    /**
     * 添加日期
     */
    private Date addDate;
    /**
     * 操作内容
     */
    private String operate;
    /**
     * 操作员ID
     */
    private Integer hrId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

}