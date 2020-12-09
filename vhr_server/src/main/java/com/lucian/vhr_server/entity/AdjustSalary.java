package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (AdjustSalary)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:08
 */
public class AdjustSalary implements Serializable {
    private static final long serialVersionUID = -88803276078653366L;

    private Integer id;

    private Integer eId;
    /**
     * 调薪日期
     */
    private Date asDate;
    /**
     * 调前薪资
     */
    private Integer beforeSalary;
    /**
     * 调后薪资
     */
    private Integer afterSalary;
    /**
     * 调薪原因
     */
    private String reason;
    /**
     * 备注
     */
    private String remark;


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

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Integer getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}