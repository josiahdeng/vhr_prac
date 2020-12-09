package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (HrRole)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:25
 */
public class HrRole implements Serializable {
    private static final long serialVersionUID = 932757934163717733L;

    private Integer id;

    private Integer hrId;

    private Integer rId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

}