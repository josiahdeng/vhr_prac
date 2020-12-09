package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeEc)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:16
 */
public class EmployeeEc implements Serializable {
    private static final long serialVersionUID = -52666717684960232L;

    private Integer id;
    /**
     * 员工编号
     */
    private Integer eId;
    /**
     * 奖罚日期
     */
    private Date ecDate;
    /**
     * 奖罚原因
     */
    private String ecReason;
    /**
     * 奖罚分
     */
    private Integer ecPoint;
    /**
     * 奖罚类别，0：奖，1：罚
     */
    private Integer ecType;
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

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public Integer getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }

    public Integer getEcType() {
        return ecType;
    }

    public void setEcType(Integer ecType) {
        this.ecType = ecType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}