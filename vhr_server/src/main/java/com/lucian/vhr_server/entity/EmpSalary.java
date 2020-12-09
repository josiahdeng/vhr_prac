package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (EmpSalary)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:11
 */
public class EmpSalary implements Serializable {
    private static final long serialVersionUID = 165301066715718306L;

    private Integer id;

    private Integer eId;

    private Integer sId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

}